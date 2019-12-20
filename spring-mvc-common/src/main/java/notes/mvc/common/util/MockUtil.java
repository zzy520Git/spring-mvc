package notes.mvc.common.util;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.annotation.mock.MockObj;
import notes.mvc.common.annotation.mock.MockValue;
import notes.mvc.common.response.ResponseResult;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description：Mock数据工具类
 *
 * @author zzy520git
 * @date 2019/8/8 14:17
 * @ see
 * @since
 */
@Slf4j
public class MockUtil {
    private static final Boolean[] BOOLS = new Boolean[]{true, false};

    private static final char[] WORDS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final Random R = new Random();

    private static final int MAX_COLLECTION_LENGTH = 3;

    private static final int MAX_STRING_LENGTH = 15;

    private static final Deque<Class<?>> CLASS_DEQUE = new LinkedList<>();

    /**
     * 仅用于测试环境产生Mock数据
     * 注意所有的类都应该是public的
     *
     * @param clazz  请传入自定义类型，不支持Map,Set,List,枚举等
     * @param classR 泛型或接口实现类
     * @param <T>
     * @return
     */
    public static synchronized <T> T mock(Class<T> clazz, Class<?> classR) {
        if (clazz == null) {
            return null;
        }
        if (clazz == Map.class || clazz == List.class) {
            return null;
        }
        CLASS_DEQUE.clear();
        T t = mockRecursive(clazz, classR);
        CLASS_DEQUE.clear();
        return t;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static synchronized <T> T mockRecursive(Class<T> clazz, Class<?> classR) {
        T temp = dealBaseClass(clazz);
        if (temp != null) {
            return temp;
        }
        boolean enter = false;
        try {
            if (hasFound(clazz)) {
                return newInstance(clazz, classR);
            }
            CLASS_DEQUE.push(clazz);
            enter = true;
            T instance = newInstance(clazz, classR);
            if (instance == null) {
                return null;
            }

            Class<?> cc = clazz;

            for (; cc != Object.class; cc = cc.getSuperclass()) {
                for (Field f : cc.getDeclaredFields()) {
                    try {
                        f.setAccessible(true);

                        //防止无限递归
                        if (f.getType() == cc) {
                            MockObj mockObj = f.getDeclaredAnnotation(MockObj.class);
                            Class<?> r = null;
                            if (mockObj != null) {
                                r = mockObj.value();
                            }
                            f.set(instance, newInstance(cc, r));
                            continue;
                        }

                        String mockValue = getMockValue(f);
                        if (dealBaseType(instance, f, mockValue)) {
                            //是否处理过
                            continue;
                        } else if (f.getType() == List.class) {
                            Class<?> r = classR;
                            MockObj mockObj = f.getDeclaredAnnotation(MockObj.class);
                            if (mockObj != null) {
                                r = mockObj.value();
                            }

                            ParameterizedType pt = (ParameterizedType) f.getGenericType();
                            Class<?> listClazz = null;
                            try {
                                listClazz = (Class) pt.getActualTypeArguments()[0];
                            } catch (Exception e) {
                                log.error("MockUtil异常", e);
                            }
                            if (listClazz == null) {
                                if (r == null) {
                                    continue;
                                }
                                listClazz = r;
                                r = classR;
                            }

                            //防止死循环
                            if (hasFound(listClazz)) {
                                f.set(instance, Collections.emptyList());
                                continue;
                            }
                            int size = R.nextInt(MAX_COLLECTION_LENGTH);
                            List<Object> list = new ArrayList<>(size);
                            for (int i = 0; i <= size; i++) {
                                list.add(mockRecursive(listClazz, r));
                            }
                            f.set(instance, list);
                        } else if (f.getType() == Map.class) {
                            ParameterizedType pt = (ParameterizedType) f.getGenericType();
                            Class<?> mapKeyClazz = (Class) pt.getActualTypeArguments()[0];
                            Class<?> mapValueClazz = (Class) pt.getActualTypeArguments()[1];
                            //防止死循环
                            if (hasFound(mapKeyClazz) && hasFound(mapValueClazz)) {
                                f.set(instance, Collections.emptyMap());
                                continue;
                            }

                            int size = R.nextInt(MAX_COLLECTION_LENGTH);
                            Map<Object, Object> map = new HashMap<>();
                            for (int i = 0; i <= size; i++) {
                                map.put(mockRecursive(mapKeyClazz, null),
                                        mockRecursive(mapValueClazz, null));
                            }
                            f.set(instance, map);
                        } else if (f.getType() == Set.class) {
                            Class<?> r = classR;
                            MockObj mockObj = f.getDeclaredAnnotation(MockObj.class);
                            if (mockObj != null) {
                                r = mockObj.value();
                            }
                            ParameterizedType pt = (ParameterizedType) f.getGenericType();
                            Class<?> listClazz = null;
                            try {
                                listClazz = (Class) pt.getActualTypeArguments()[0];
                            } catch (Exception e) {
                                log.error("MockUtil异常", e);
                            }
                            if (listClazz == null) {
                                if (r == null) {
                                    continue;
                                }
                                listClazz = r;
                                r = classR;
                            }

                            //防止死循环
                            if (hasFound(listClazz)) {
                                f.set(instance, Collections.emptySet());
                                continue;
                            }
                            int size = R.nextInt(MAX_COLLECTION_LENGTH);
                            Set<Object> set = new HashSet<>(size);
                            for (int i = 0; i <= size; i++) {
                                set.add(mockRecursive(listClazz, r));
                            }
                            f.set(instance, set);
                        } else {
                            Class<?> r = classR;
                            MockObj mockObj = f.getDeclaredAnnotation(MockObj.class);
                            if (mockObj != null) {
                                r = mockObj.value();
                            }
                            f.set(instance, mockRecursive(f.getType(), r));
                        }
                    } catch (Exception e) {
                        log.error("MockUtil异常", e);
                    }
                }
            }
            return instance;
        } catch (Exception e) {
            log.error("MockUtil异常", e);
            throw new IllegalArgumentException(e);
        } finally {
            //递归处理，循环引用问题
            if (enter) {
                if (!CLASS_DEQUE.isEmpty()) {
                    CLASS_DEQUE.pop();
                }
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T> T dealBaseClass(Class<T> clazz) {
        if (clazz == Character.class || clazz == Character.TYPE) {
            return (T) (Character) WORDS[R.nextInt(WORDS.length)];
        } else if (clazz == Boolean.class || clazz == Boolean.TYPE) {
            return (T) BOOLS[R.nextInt(BOOLS.length)];
        } else if (clazz == Byte.class || clazz == Byte.TYPE) {
            return (T) (Byte) new Integer(R.nextInt(127)).byteValue();
        } else if (clazz == Date.class) {
            return (T) new Date();
        } else if (clazz == Long.class || clazz == Long.TYPE) {
            return (T) (Long) R.nextLong();
        } else if (clazz == Integer.class || clazz == Integer.TYPE) {
            return (T) (Integer) R.nextInt();
        } else if (clazz == Short.class || clazz == Short.TYPE) {
            return (T) (Short) new Integer(R.nextInt(127)).shortValue();
        } else if (clazz == Float.class || clazz == Float.TYPE) {
            return (T) (Float) R.nextFloat();
        } else if (clazz == Double.class || clazz == Double.TYPE) {
            return (T) (Double) R.nextDouble();
        } else if (clazz == String.class) {
            return (T) randString(R.nextInt(MAX_STRING_LENGTH));
        } else if (clazz == BigDecimal.class) {
            return (T) new BigDecimal("1.2");
        } else {
            return null;
        }
    }

    private static <T> boolean dealBaseType(T instance, Field f, String mockValue) throws Exception {
        boolean flag = true;
        if (f.getType() == Byte.TYPE || f.getType() == Byte.class) {
            if (mockValue != null) {
                f.set(instance, Byte.valueOf(mockValue));
            } else {
                f.set(instance, new Integer(R.nextInt(127)).byteValue());
            }
        } else if (f.getType() == BigDecimal.class) {
            if (mockValue != null) {
                f.set(instance, new BigDecimal(mockValue));
            } else {
                f.set(instance, new BigDecimal("1.2"));
            }
        } else if (f.getType() == Character.class || f.getType() == Character.TYPE) {
            f.set(instance, WORDS[R.nextInt(WORDS.length)]);
        } else if (f.getType() == Boolean.TYPE || f.getType() == Boolean.class) {
            f.set(instance, BOOLS[R.nextInt(BOOLS.length)]);
        } else if (f.getType() == Long.class || f.getType() == Long.TYPE) {
            if (mockValue != null) {
                f.set(instance, Long.valueOf(mockValue));
            } else {
                f.set(instance, R.nextLong());
            }
        } else if (f.getType() == Integer.class || f.getType() == Integer.TYPE) {
            if (mockValue != null) {
                f.set(instance, Integer.valueOf(mockValue));
            } else {
                f.set(instance, R.nextInt());
            }
        } else if (f.getType() == Short.class || f.getType() == Short.TYPE) {
            if (mockValue != null) {
                f.set(instance, Short.valueOf(mockValue));
            } else {
                f.set(instance, new Integer(R.nextInt(127)).shortValue());
            }
        } else if (f.getType() == Float.class || f.getType() == Float.TYPE) {
            if (mockValue != null) {
                f.set(instance, Float.valueOf(mockValue));
            } else {
                f.set(instance, R.nextFloat());
            }
        } else if (f.getType() == Double.class || f.getType() == Double.TYPE) {
            if (mockValue != null) {
                f.set(instance, Double.valueOf(mockValue));
            } else {
                f.set(instance, R.nextDouble());
            }
        } else if (f.getType() == String.class) {
            if (mockValue != null) {
                f.set(instance, mockValue);
            } else {
                f.set(instance, randString(R.nextInt(MAX_STRING_LENGTH)));
            }
        } else if (f.getType() == Date.class) {
            if (mockValue != null) {
                f.set(instance, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mockValue));
            } else {
                f.set(instance, new Date());
            }
        } else {
            flag = false;
        }
        return flag;
    }

    private static <T> T newInstance(Class<T> clazz, Class<?> rclass) {
        try {
            return clazz.newInstance();
        } catch (Throwable e) {
            log.error("MockUtil异常", e);
            try {
                if (rclass != null) {
                    return (T) rclass.newInstance();
                }
            } catch (Throwable t) {
                log.error("MockUtil异常", t);
            }
            return null;
        }
    }

    private static String randString(int count) {
        if (count <= 0) {
            count = 1;
        }
        int length = WORDS.length;
        char[] text = new char[count];
        for (int i = 0; i < count; i++) {
            text[i] = WORDS[R.nextInt(length)];
        }
        return new String(text);
    }

    private static boolean hasFound(Class<?> clz) {
        boolean flag = false;
        for (Class<?> cls : CLASS_DEQUE) {
            if (cls == clz) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static String getMockValue(Field f) {
        MockValue mockValue = f.getDeclaredAnnotation(MockValue.class);
        if (mockValue != null && mockValue.value().length > 0) {
            int index = R.nextInt(mockValue.value().length);
            return mockValue.value()[index];
        }
        return null;
    }

    public static void main(String[] args) {
        ResponseResult b = mock(ResponseResult.class, null);
        System.out.println(JsonUtil.toJSONString(b));
    }

}




