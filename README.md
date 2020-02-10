Sample Selenium project performing sanity test of Outlook login functionality. 

## Project design
- The project is based on [Basic Selenium Project - legacy](https://github.com/christian-draeger/basic-selenium-project/tree/legacy) which brings:
    - Maven configuration
    - All popular browsers support (using WebDriver Manager)
    - Popular design patterns: Page Object & Page Factory
    - Configuration by annotations (browser, screen size, user agent)
    - Convenience methods for Selenium
- Things added on top of the base project:
    - [Lombok](https://projectlombok.org/) (for boilerplate code elimination)
    - JUnit 4 replaced with [TestNg](https://testng.org/doc/) (for better test execution optimization)
    - Firefox replaced with Chrome as a default browser

## Run project with Maven
- Prerequisites: JDK >= 8
- Checkout project with GIT: https://github.com/Agata05/sample-project-outlook.git
- Set up `login` and `password` variables in `test_config.properties` file 
- From the project directory run command `mvn clean test`
    - Test report will be generated in: _target/surefire-reports/html/index.html_
    - Output report ready for integration with CI tools (e.g. Jenkins builds)
    - Change browser by adding parameter: 
    `-Pbrowser-chrome|browser-chrome-headless|browser-firefox|browser-firefox-headless|browser-edge|browser-internetexplorer|browser-opera`
    (chrome being the default)

## Open Project with Intellij
- Install [Lombok plugin](https://plugins.jetbrains.com/plugin/6317-lombok)
- Add "Framework Support" for Maven
- To change browser select proper profile on Maven tab