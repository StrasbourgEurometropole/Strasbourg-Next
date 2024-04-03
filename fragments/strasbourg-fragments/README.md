# Strasbourg Fragments

This project has been created with [generator-liferay-fragments][1]. You can read
how to manage this project in the [generator documentation][2].

This can deploy fragments in collections, fragment composition and master page.

This project is tested with Liferay 7.4 Q4 (GA102)

> ⚠ Some of the generated fragments might not be compatible with every Liferay
> portal version, please check the [fragment's generator documentation][3] or
> your Liferay documentation to be sure you can use them.

## Usage
To use this project, you need to have [Node.js](https://nodejs.org/en/) and [npm](https://www.npmjs.com/) installed on your machine.

To install the dependencies, run the following command in the project's root directory:

```bash
npm install
```

To compile the fragments, fragment composition and master page, run the following command in the project's root directory:

```bash
npm run compress
```

When you run the command, say Y to add descriptor

then for the company id, keep `liferay.com`
for the group id, type `Strasbourg.eu`

This will create .zip files in the `build` folder. You can then upload the .zip to /deploy folder of your Liferay instance. It will automatically deploy the fragments, fragment composition and master page.


## Exporting fragments

To export the fragments, fragment composition and master page of the current liferay instance, run the following command in the project's root directory:

```bash
npm run export
```

This will modify the files with the new fragments, fragment composition and master page or update the files if they already exist.

[1]: https://www.npmjs.com/package/generator-liferay-fragments
[2]: https://www.npmjs.com/package/generator-liferay-fragments#usage
[3]: https://www.npmjs.com/package/generator-liferay-fragments#creating-new-fragments
