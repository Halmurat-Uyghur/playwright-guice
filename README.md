# Playwright Guice Framework

This project is a template for building a test automation framework in Java using [Playwright](https://playwright.dev/java/) and [Google Guice](https://github.com/google/guice). Maven is used for the build system and dependency management.

## Features

- **Playwright for Java** for browser automation
- **Google Guice** for dependency injection
- **Maven** to handle builds and dependency resolution
- Example structure for page objects and tests
- **Parallel test execution** enabled via JUnit 5

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.x
- (Optional) Node.js if you wish to manage Playwright browsers via `npx playwright install`

### Installation

Clone the repository and run a Maven build:

```bash
mvn clean install
```

### Running Tests

Execute the following command to run the test suite:

```bash
mvn test
```

Tests run in parallel by default. The parallel execution settings are defined in
`src/test/resources/junit-platform.properties`. You can control the number of
parallel threads by editing the property
`junit.jupiter.execution.parallel.config.fixed.parallelism` in this file.

### Example Test

The project includes a sample test (`ExampleTest`) that opens the
[Playwright](https://playwright.dev/) website and asserts that the page
title contains the word `Playwright`. This demonstrates using the Guice
injection setup provided in `BaseTest` and the `PlaywrightModule`.

### Configuration

Runtime configuration is stored in `src/main/resources/config.properties`.
Currently the following settings are supported:

```
headless=true        # Launch browser in headless mode
timeoutInSeconds=10  # Default timeout used by `WaitUtil`
```

## Project Structure

Typical Maven layout is recommended:

```
src/
  main/java/        # Guice modules and shared utilities
  test/java/        # Playwright tests and page objects
```

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

Distributed under the MIT License.
