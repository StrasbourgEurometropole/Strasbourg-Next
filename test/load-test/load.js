
module.exports = { loadStrasbourg };

async function loadStrasbourg(page) {
    await page.goto('https://ems-recette-liferay2.sully-group.fr/');
}