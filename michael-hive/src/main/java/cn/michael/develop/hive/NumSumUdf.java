package cn.michael.develop.hive;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

/**
 * Created by hufenggang on 2020/9/17.
 *
 * 返回数字的大写方式
 */

@Description(
    name="num_sum",
    value="_FUNC_(string arg1, string arg2) - input two string",
    extended="return the id corresponding to arg1\n" +
        "Example:\n" +
        "> SELECT _FUNC_(\"中国\", \"12\") FROM dual;\n"
)

public class NumSumUdf extends GenericUDF {

    @Override
    public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {

        if(arguments.length != 2) {
            throw new UDFArgumentLengthException("Function must have 1 arguments.");
        }

        return PrimitiveObjectInspectorFactory.javaIntObjectInspector;
    }

    @Override
    public Object evaluate(DeferredObject[] arguments) throws HiveException {
        int value1 = Integer.parseInt(arguments[0].get().toString());
        int value2 = Integer.parseInt(arguments[1].get().toString());
        return value1 + value2;
    }

    @Override
    public String getDisplayString(String[] children) {
        return "The sum of num1 and num2";
    }
}
