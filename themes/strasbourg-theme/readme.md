# Strasbourg Theme for Liferay 7.4

The Strasbourg Theme is a custom theme designed for Liferay 7.4, offering a sleek and modern look for your Liferay portal. This theme is based on Node.js and requires Node version 16.13.0 to ensure smooth compilation and deployment processes.

## Installation

To set up the Strasbourg Theme, make sure you have Node version 16.13.0 installed on your system, and then run the following command:

```bash
npm i
```



This command will install all the required dependencies for the Strasbourg Theme.
## Compilation and Deployment

To compile and deploy the Strasbourg Theme, follow these steps:
1. Ensure you have Node version 16.13.0 installed on your system.
2. Open a terminal or command prompt in the root directory of your Strasbourg Theme project.
3. Run the following command:

```bash

gulp deploy
```



This will initiate the compilation process and deploy the theme to your Liferay portal.
## Liferay Theme Configuration

Before deploying the Strasbourg Theme, ensure that you have correctly configured the `liferay-theme.json` file to match your local development environment. Open the `liferay-theme.json` file and make the following changes:

```json

{
  "LiferayTheme": {
    "appServerPath": "C:/liferay/ems-workspace/Strasbourg-Next/bundles/tomcat-9.0.68",
    "deployPath": "C:/liferay/ems-workspace/Strasbourg-Next/bundles/deploy",
    "deployed": true,
    "deploymentStrategy": "LocalAppServer",
    "url": "http://localhost:8080"
  }
}
```



Make sure that the `appServerPath` and `deployPath` values correspond to the correct paths on your local machine. These paths should point to the location of your Liferay 7.4 server's Tomcat and the deployment directory, respectively.

## Gulpfile.js Overview

The `gulpfile.js` for the Strasbourg Theme contains several tasks that help streamline the theme development process. These tasks automate tasks such as Sass globbing, CSS compilation, and JavaScript minification. Below is an overview of each task and its purpose:
### 1. `sassGlob` Task

The `sassGlob` task utilizes the `gulp-sass-glob` plugin to simplify the Sass import process. It automatically resolves the glob patterns in the Sass files and efficiently imports all the required partials. This ensures that your Sass files are well-organized and easier to maintain.


### 2. `before:build:compile-css` Hook

The `before:build:compile-css` hook runs the `sassGlob` task before the main CSS compilation process. It ensures that the Sass globbing is performed, and the dependencies are resolved before generating the final CSS files.


### 3. `before:build:war` Hook

The `before:build:war` hook is executed before building the final `.war` file for deployment. This task is responsible for minifying and concatenating JavaScript files into a single `strasbourg.min.js` file. The task uses `gulp-concat`, `gulp-sourcemaps`, and `gulp-uglify` plugins to achieve this.



## Feedback and Support

If you encounter any issues or have suggestions for improving the Strasbourg Theme, feel free to [raise an issue](https://github.com/your-repo/strasbourg-theme/issues)  on our GitHub repository. We welcome contributions and community feedback.

Thank you for using the Strasbourg Theme for Liferay 7.4! We hope you enjoy the modern and elegant look it brings to your Liferay portal. Happy theming!
