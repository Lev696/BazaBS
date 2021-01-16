package by.mts.dom.lev;

public class Human {
    // Поля класса
    public String name;
    protected String surname;
    int age;
    private int weight;

    public static int humansCount = 0;                      // Статическое поле - ОДНО для всего класса
    final int classId;
    static final String humansGreeting = "Приветствую вас дорогие друзья и гости, рад видеть вас!";      // Статическое финализированное поле - ОДНО НЕИЗМЕНЯЕМОЕ для всего класса

    {                                                       // Инициализатор - код, который выполняется ДО любого конструктора при создании ОБЪЕКТА этого КЛАССА
        humansCount++;
        classId = 14;
        System.out.println("Сработал Human нициализатор! (было обращение к конструктору)");
    }

    // ################################################################################################################
    // КОНСТРУКТОРЫ, объявляются как - МОД_ДОСТУПА ИМЯ_КЛАССА(ПАРАМЕТРЫ) { выполняемый код ... }
    public Human() {                                        // Такой конструктор (без входных параметров) создается по умолчанию ЕСЛИ не объявлены другие конструкторы
        System.out.println("Создан объект Хуман без переданных параметров");  // Такой конструктор (без входных параметров) ОБЯЗАТЕЛЕН если у этого класса есть НАСЛЕДНИКИ
    }

    public Human(String name, String surname) {             // Конструктор с ДВУМЯ входными параметрами ТИПА String
        System.out.println("Создан объект Human с 2-мя тектовыми полями: " +name+ ", "+surname);
        this.name = name;
        this.surname = surname;
    }

    Human(int age) {                                        // Тоже конструктор с ОДНИМ входным параметром ТИПА int БЕЗ модификатора доступа (default)
        System.out.println("Создан объект Human с полем 'Возраст': " +age);
        this.age = age;
    }

    public Human(String name, String surname, int age, int weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        System.out.println("Создан объект Human со всеми полями");
        System.out.println("Этим конструктором мы НАОБМАНУЛИ!!! проверку на вес");
    }

    // ################################################################################################################
    // МЕТОДЫ, объявляются как МОД_ДОСТУПА ТИП_ВОЗВРАЩАЕМОГО_ЗНАЧЕНИЯ ИМЯ_МЕТОДА(ПАРАМЕТРЫ) { выполняемый код ... }
    public void doDiet() {                                  // Обычный метод класса который что-то там делает, метод доступен для вызова ВЕЗДЕ (public)
        System.out.println("Метод doDieta(): " + name + " " + surname + " на диете");
        decreaseWeight();
    }

    public void Human() {                                   // ТОЖЕ обычный метод класса который что-то там делает, метод доступен для вызова ВЕЗДЕ (public)
        System.out.println("Выполнился метод Human()");
    }

    private void decreaseWeight() {                         // ТОЖЕ обычный метод класса который что-то там делает, метод доступен для вызова только ВНУТРИ класса (private)
        System.out.println("Метод decreaseWeight()");
        if(weight > 0) {
            System.out.println("weight = " + this.weight);
            this.weight--;
            System.out.println("Вес стал " + this.weight + " и уменьшился на 1");
        }
        else System.out.println("Вес итак слишком мал: " + this.weight);
    }

    // Сеттер - назначает(меняет) вес, вызывается извне
    public void setWeight(int weight) {
        if(weight > 0)
            this.weight = weight;
        else this.weight = 1;
    }

    // Геттер - отдаёт вес, вызывается извне
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", classId=" + classId +
                '}';
    }
}

class HumanMain {
    public static void main(String[] args) {
        Human Vasya = new Human("Вася", "Пупкин");
        Vasya.age=25;
        Vasya.setWeight(60);
        Vasya.doDiet();
        Vasya.name="Василий";
        Vasya.surname="Пуповинкин";
        Human Fedya = new Human(24);
        Fedya.surname = "Залипкин";
        Fedya.name = "Феденька";
        Fedya.setWeight(75);
        Fedya.Human();
        Fedya.age=45;
        Human Lena = new Human();
        Lena.name = "Елена";
        Lena.surname = "Прекрасная";
        Lena.age = 30;
        Lena.setWeight(-6);
        Lena.doDiet();
        Human Polniy = new Human("Иван", "Иванов", 37, -107);
        System.out.println(Vasya);
        System.out.println(Fedya);
        System.out.println(Lena);
        System.out.println(Polniy);
        System.out.println("Количество созданных экземпляров Людей: " + Human.humansCount);

    }
}
