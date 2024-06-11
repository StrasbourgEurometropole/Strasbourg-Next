document.addEventListener("DOMContentLoaded", function() {
    var namespace = "_eu_strasbourg_portlet_association_SearchAssociationPortlet_";
    var namespaceAUI = "#" + namespace;

    // Sélection des éléments DOM
    var domainsSelect = document.querySelector('select.domains');
    var specialityWidget = document.querySelector('.st-group-field.speciality');
    var specialitiesSelect = document.querySelector('select.specialities');
    var subSpecialityWidget = document.querySelector('.st-group-field.subSpeciality');
    var subSpecialitiesSelect = document.querySelector('select.subSpecialities');
    var subSubSpecialityWidget = document.querySelector('.st-group-field.subSubSpeciality');
    var subSubSpecialitiesSelect = document.querySelector('select.subSubSpeciality');

    // Liaison des événements
    domainsSelect.addEventListener('change', onDomainChange);
    specialitiesSelect.addEventListener('change', onSpecialitiesChange);
    subSpecialitiesSelect.addEventListener('change', onSubSpecialitiesChange);

    // Fonction pour récupérer les catégories à partir d'un ID de catégorie parent
    function fetchCategories(parentCategoryId, callback) {
        Liferay.Service('/strasbourg.strasbourg/get-practice-categories', {
            parentCategoryId: parentCategoryId,
            localeId: Liferay.ThemeDisplay.getLanguageId()
        }, callback);
    }

    // Fonction pour peupler un élément select avec des données
    function populateSelect(selectElement, data) {
        selectElement.innerHTML = '<option value="">Tout afficher</option>';
        data.forEach(function(categ) {
            var option = document.createElement('option');
            option.value = categ.id;
            option.textContent = categ.title;
            selectElement.appendChild(option);
        });
    }

    // Fonction pour réinitialiser les éléments select et masquer les widgets correspondants
    function resetSelects() {
        specialityWidget.style.display = 'none';
        subSpecialityWidget.style.display = 'none';
        subSubSpecialityWidget.style.display = 'none';
        populateSelect(specialitiesSelect, []);
        populateSelect(subSpecialitiesSelect, []);
        populateSelect(subSubSpecialitiesSelect, []);
    }

    // Fonction déclenchée lors du changement de domaine
    function onDomainChange() {
        var selectedDomain = this.value;
        if (selectedDomain) {
            fetchCategories(selectedDomain, function(data) {
                populateSelect(specialitiesSelect, data);
                specialityWidget.style.display = 'block';
                specialitiesSelect.dispatchEvent(new Event('change'));
            });
            subSpecialityWidget.style.display = 'none';
            subSubSpecialityWidget.style.display = 'none';
        } else {
            resetSelects();
        }
    }

    // Fonction déclenchée lors du changement de spécialité
    function onSpecialitiesChange() {
        var selectedSpeciality = this.value;
        if (selectedSpeciality) {
            fetchCategories(selectedSpeciality, function(data) {
                populateSelect(subSpecialitiesSelect, data);
                if (data.length > 0) {
                    subSpecialityWidget.style.display = 'block';
                } else {
                    subSpecialityWidget.style.display = 'none';
                    subSpecialitiesSelect.value = "";
                }
                subSpecialitiesSelect.dispatchEvent(new Event('change'));
            });
            subSubSpecialityWidget.style.display = 'none';
        } else {
            subSpecialityWidget.style.display = 'none';
            subSubSpecialityWidget.style.display = 'none';
            populateSelect(subSpecialitiesSelect, []);
            subSpecialitiesSelect.dispatchEvent(new Event('change'));
        }
    }

    // Fonction déclenchée lors du changement de sous-spécialité
    function onSubSpecialitiesChange() {
        var selectedSubSpeciality = this.value;
        if (selectedSubSpeciality) {
            fetchCategories(selectedSubSpeciality, function(data) {
                populateSelect(subSubSpecialitiesSelect, data);
                if (data.length > 0) {
                    subSubSpecialityWidget.style.display = 'block';
                } else {
                    subSubSpecialityWidget.style.display = 'none';
                    subSubSpecialitiesSelect.value = "";
                }
                subSubSpecialitiesSelect.dispatchEvent(new Event('change'));
            });
        } else {
            subSubSpecialityWidget.style.display = 'none';
            populateSelect(subSubSpecialitiesSelect, []);
            subSubSpecialitiesSelect.dispatchEvent(new Event('change'));
        }
    }
});
