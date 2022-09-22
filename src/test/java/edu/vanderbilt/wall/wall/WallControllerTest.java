package edu.vanderbilt.wall.wall;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.junit.jupiter.api.Assertions.*;




public class WallControllerTest {
    private Class getTestReader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String pathToJar = "defensive-filtering.main.jar";
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);
        Class c = null;
        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            c = cl.loadClass(className);
            break;
        }
        return c;
    }

    @Test
    public void displayComment() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        WallController wallController = new WallController();
        Class o = getTestReader();
        Field correctField = o.getField("CORRECT");
        Field testField = o.getField("TEST");
        String[] correct = (String[])(correctField.get(null));
        String[] test = (String[])testField.get(null);
        for (int i=0; i<test.length; i++){
            ModelAndView mv = wallController.displayComment(test[i]);
            assertEquals(correct[i], mv.getModel().get("comment"));
        }
        System.out.println("All test cases passed");
    }


}
