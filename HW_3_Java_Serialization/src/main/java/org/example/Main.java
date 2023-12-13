package org.example;

import java.io.*;

// Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
// Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
// Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
// Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Дмитрий",19,4.4);

        try{
            FileOutputStream outputStream = new FileOutputStream("student.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            outputStream.close();

            System.out.println("Объект успешно сериализован в файл 'student.ser'.\"");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Student deserialStudent = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("student.ser");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            deserialStudent = (Student) inputStream.readObject();
                                        inputStream.close();
                                        fileInputStream.close();

            System.out.println("Объект успешно десериализован из файла 'student.ser'.");
        } catch (IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }

        System.out.println("Имя " + deserialStudent.getName());
        System.out.println("Возраст " + deserialStudent.getAge());
        System.out.println("Средний балл " + deserialStudent.getGPA());

        System.out.println("Значение GPA не сохранено/восстановлено, так как оно является transient.");

    }

}
