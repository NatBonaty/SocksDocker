# Магазин с носками

1. Поднять контейнер из https://github.com/microservices-demo/microservices-demo .
2. Написать на языке Java e2e тест по авторизации и добавления товара в корзину.
3. Проверить, что сумма цены товаров в корзине соответствует сумме цен заказанных товаров.
4. В проекте использовать стек Java, Gradle, JUnit5, Playwright , Faker/ либо любой другой генератор данных, Allure2. 
5. После прохождения тестов должен формироваться Allure-отчет.

### Запуск тестов

./gradlew test

### Загрузка Allure:

npm i - @playwright/test allure-playwright

npm install -g allure-commandline

### Запуск Allure-отчета

allure serve build/allure-results