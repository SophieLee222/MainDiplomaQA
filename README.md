# Дипломная работа (мобильное тестирование Appium + JUnit5 + Allure)

## Требования окружения
- **JDK 21** (Temurin/OpenJDK)
- **Gradle Wrapper** ≥ 8.10.2
- **Android SDK / AVD** (эмулятор API 34+ или реальное устройство)
- **Appium Server** ≥ 2.x и драйвер `uiautomator2`
- **Node.js** (для Appium)
- **Allure Commandline** (для локального просмотра HTML-отчётов)

### Быстрый старт (macOS)
```bash
brew install --cask temurin@21
brew install allure
npm install -g appium
appium driver install uiautomator2
```

### Быстрый старт (Windows)
```bash
choco install openjdk --version=21
choco install allure-commandline
npm install -g appium
appium driver install uiautomator2
```

## Сборка и запуск авто-тестов
1. Запустите эмулятор Android или подключите устройство.
2. Убедитесь, что Appium запущен на `http://127.0.0.1:4723`.
3. Выполните:
```bash
# macOS / Linux
./gradlew clean test

# Windows
gradlew.bat clean test
```

## Просмотр отчёта Allure

Если хотите сгенерировать свой отчёт локально (на основе allure-results):
```bash
./gradlew allureReport
```
Готовый отчёт появится в `build/reports/allure-report/index.html`.

### Просмотр готового отчёта из архива
В репозитории приложен **готовый HTML-отчёт Allure** — архив `allure-report.zip`.

Чтобы просмотреть результаты:
1. Распакуйте `allure-report.zip`.
2. Откройте файл `index.html` в браузере.

Отчёт содержит полную статистику прогонов, скриншоты и логи шагов.

## Покрытие тестами
| Модуль | Тесты |
|--------|--------|
| Авторизация | позитивные/негативные сценарии |
| Новости | просмотр, добавление, редактирование, удаление |
| Цитаты | раскрытие карточек |
| Интерфейс | темы, локализация, ориентация |
| Навигация | переходы между разделами |
