package io.sweetheart.examples.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Nashorn6 {
    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("load('res/nashorn6.js)");

        Invocable invocable = (Invocable) engine;

        Product product = new Product();
        product.setName("Rubber");
        product.setPrice(1.99);
        product.setStock(1377);

        ScriptObjectMirror result = (ScriptObjectMirror)invocable.invokeFunction("calculate", product);
        System.out.println(result.get("name") + ":" + result.get("valueOfGoods"));
    }
}
