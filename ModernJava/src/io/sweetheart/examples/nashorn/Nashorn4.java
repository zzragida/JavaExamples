package io.sweetheart.examples.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Nashorn4 {
    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("loadWithNewGlobal('res/nashorn4.js')");
    }
}
