# Stellar Burgers — Unit Testing (Диплом 1)

Учебный проект по покрытию кода юнит-тестами.  
Цель — полностью протестировать класс `Burger` с использованием **JUnit 4**, **Mockito** и **параметризации**, а также добиться **100% покрытия** кода через JaCoCo.

---

## Задание

Необходимо протестировать программу оформления заказа бургера в **Stellar Burgers**.

**Требования:**
- Использовать **моки** и **стабы** (Mockito)
- Применять **параметризованные тесты**
- Покрыть тестами класс `Burger`
- Достичь **100% покрытия** кода (JaCoCo)

---

## Стек

- **Java 11**
- **Maven**
- **JUnit 4.13.2**
- **Mockito 5.23.0**
- **JaCoCo 0.8.12**

---

## Структура проекта
```bash
Diplom_1/
├── src/
│   ├── main/java/praktikum/
│   │   ├── Bun.java
│   │   ├── Burger.java          ← основной тестируемый класс
│   │   ├── Database.java
│   │   ├── Ingredient.java
│   │   ├── IngredientType.java
│   │   └── Praktikum.java
│   └── test/java/praktikum/
│       ├── BurgerMoveIngredientTest.java
│       ├── TestBunParameterized.java
│       ├── TestBurger.java
│       ├── TestingredientParameterized.java
│       └── TestingredientType.java
├── pom.xml
└── README.md
```

---

## Как запустить проект

### 1. Клонирование
```sh
git clone https://github.com/berezikovM/Diplom_1.git
```
```sh
cd Diplom_1
```

### 2. Установка зависимостей
```sh
mvn clean install
```

### 3. Запуск тестов
```sh
mvn test
```

### 4. Генерация отчёта JaCoCo (покрытие)
```sh
mvn jacoco:report
```
Отчет будет доступен по пути:
target/site/jacoco/index.html