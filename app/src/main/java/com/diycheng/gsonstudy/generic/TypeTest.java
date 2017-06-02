package com.diycheng.gsonstudy.generic;

import android.util.Log;

import junit.framework.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * Created by liwangcheng on 2017/6/2 07:10.
 */

public class TypeTest <K extends Comparable & Serializable, V, T> {

    private static final String TAG = "TypeTest";

    Map<String, String> map;
    public void testParameterizedType() throws NoSuchFieldException {
        Field f = TypeTest.class.getDeclaredField("map");
        Log.e(TAG + " GenericType", f.getGenericType().toString());
        Log.e(TAG, "Is ParameterizedType " + (f.getGenericType() instanceof ParameterizedType));
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        // Type getRawType(): 返回承载该泛型信息的对象, 如上面那个Map<String, String>承载范型信息的对象是Map
        Log.e(TAG + " RawType", pType.getRawType() == null ? "NULL" : pType.getRawType().toString());
        // Type[] getActualTypeArguments(): 返回实际泛型类型列表, 如上面那个Map<String, String>实际范型列表中有两个元素, 都是String
        for (Type type : pType.getActualTypeArguments()) {
            Log.e(TAG + " ActualType", type == null ? "NULL" : type.toString());
        }
        // Type getOwnerType(): 返回是谁的member
        Type ownerType = pType.getOwnerType();
        Log.e(TAG + " OwnerType", ownerType == null ? "NULL" : ownerType.toString());
    }

    K key;
    V value;
    public void testTypeVariable() throws NoSuchFieldException {
        // 获取字段的类型
        Field fk = TypeTest.class.getDeclaredField("key");
        Field fv = TypeTest.class.getDeclaredField("value");
        Assert.assertTrue("必须为TypeVariable类型", fk.getGenericType() instanceof TypeVariable);
        Assert.assertTrue("必须为TypeVariable类型", fv.getGenericType() instanceof TypeVariable);
        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();
        // getName(): 获取在源码中定义时的名字
        Log.e(TAG + "Name", keyType.getName());
        Log.e(TAG + "Name", valueType.getName());
        // getGenericDeclaration(): 获取声明该类型变量实体
        Log.e("GenericDeclaration", keyType.getGenericDeclaration().toString());
        Log.e("GenericDeclaration", valueType.getGenericDeclaration().toString());
        // getBounds(): 获取类型变量的上边界, 若未明确声明上边界则默认为Object
        Log.e(TAG, "K 的上界");
        for (Type type : keyType.getBounds()) {
            Log.e(TAG, type.toString());
        }
        Log.e(TAG, "V 的上界");
        for (Type type : valueType.getBounds()) {
            Log.e(TAG, type.toString()); // 没明确声明上界的, 默认上界是 Object
        }
    }

    public void show(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, int[] ints) {
    }

    public void testGenericArrayType() {
        Method method = TypeTest.class.getDeclaredMethods()[1];
        Log.e(TAG, method.toString());
        // getGenericComponentType(): 返回数组的组成对象, 即被JVM编译后实际的对象
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            Log.e(TAG, type.toString() + " is GenericArrayType " + (type instanceof GenericArrayType));
        }
    }

    private List<? extends Number> a;  // // a没有下界, 取下界会抛出ArrayIndexOutOfBoundsException
    private List<? super String> b;
    public void testWildcardType() throws NoSuchFieldException {
        Field fieldA = TypeTest.class.getDeclaredField("a");
        Field fieldB = TypeTest.class.getDeclaredField("b");
        // 先拿到范型类型
        Assert.assertTrue("Is ParameterizedType", fieldA.getGenericType() instanceof ParameterizedType);
        Assert.assertTrue("Is ParameterizedType", fieldB.getGenericType() instanceof ParameterizedType);
        ParameterizedType pTypeA = (ParameterizedType) fieldA.getGenericType();
        ParameterizedType pTypeB = (ParameterizedType) fieldB.getGenericType();
        // 再从范型里拿到通配符类型
        Assert.assertTrue("Is WildcardType", pTypeA.getActualTypeArguments()[0] instanceof WildcardType);
        Assert.assertTrue("Is WildcardType", pTypeB.getActualTypeArguments()[0] instanceof WildcardType);
        /*
        注意:
         现阶段通配符只接受一个上边界或下边界, 返回数组是为了以后的扩展,
         实际上现在返回的数组的大小是1
         */
        WildcardType wTypeA = (WildcardType) pTypeA.getActualTypeArguments()[0];
        WildcardType wTypeB = (WildcardType) pTypeB.getActualTypeArguments()[0];
        // 看看通配符类型到底是什么
        Log.e(TAG + " WildcardType", wTypeA.toString()); // ? extends java.lang.Number
        Log.e(TAG + " WildcardType", wTypeB.toString()); // ? super java.lang.String
        // getUpperBounds(): 获取范型变量的上界
        // getLowerBounds(): 获取范型变量的下界
        Log.e(TAG + " UpperBounds", wTypeA.getUpperBounds()[0].toString());
        Log.e(TAG + " LowerBounds", wTypeB.getLowerBounds()[0].toString());
        /*
        再写几个边界的例子:
        List<? extends Number>, 上界为class java.lang.Number, 属于Class类型
        List<? extends List<T>>, 上界为java.util.List<T>, 属于ParameterizedType类型
        List<? extends List<String>>, 上界为java.util.List<java.lang.String>, 属于ParameterizedType类型
        List<? extends T>, 上界为T, 属于TypeVariable类型
        List<? extends T[]>, 上界为T[], 属于GenericArrayType类型
         */
    }
}
