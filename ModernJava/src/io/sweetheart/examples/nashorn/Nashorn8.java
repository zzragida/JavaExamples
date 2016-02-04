package io.sweetheart.examples.nashorn;

import io.sweetheart.examples.lambda.Person;
import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn8 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        NashornScriptEngine engine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("load('res/nashorn8.js')");

        engine.invokeFunction("evaluate1");
        engine.invokeFunction("evaluate2");
        engine.invokeFunction("evaluate3", "Foobar");
        engine.invokeFunction("evaluate3", new Person("John", "Doe"));
    }
}
