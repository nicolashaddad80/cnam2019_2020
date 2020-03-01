package fr.cnam.nfp121.revision.exercice1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    private Class<?> aClass;
    private SortedSet<String> myFieldsNames = new TreeSet<>();
    private SortedSet<String> myMethodsNames = new TreeSet<>();

    public Main(String aClassName) {

        if (this.loadClass(aClassName)) {
            this.getDeclaredFieldsNames();
            this.getDeclaredMethodsNames();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(new Main("fr.cnam.revision.exercice1." + args[0]).displayFielsHavingMethod());
    }

    private boolean loadClass(String fileName) {

        Boolean loadSuccess = false;
        try {
            this.aClass = Class.forName(fileName);
            loadSuccess = true;
        } catch (ClassNotFoundException e) {
            System.out.println("Aucune Class n'est presente dans le fichier " + fileName + "\n Veuillez essayer avec un autre afichier");
        }
        return loadSuccess;
    }

    private void getDeclaredFieldsNames() {
        //Getting all Fields from the class

        Field[] fields = aClass.getDeclaredFields();
        //constructing a list of Fields names
        for (Field field : fields) {
            this.myFieldsNames.add(field.getName());
        }
    }

    private void getDeclaredMethodsNames() {
        //Getting all Methods from the class
        Method[] methods = aClass.getDeclaredMethods();

        //constructing a list of Methods names
        for (Method method : methods) {
            this.myMethodsNames.add(method.getName());
        }
    }

    public String displayFielsHavingMethod() {
        StringBuilder s = new StringBuilder();
        //Adding Fields that have a method name as Field name
        for (String fieldName : this.myFieldsNames) {
            if (this.myMethodsNames.contains(fieldName))
                s.append(fieldName + "\n");
        }
        return s.toString();
    }
}
