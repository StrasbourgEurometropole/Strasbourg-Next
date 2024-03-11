(function () {
    /*
 *   This content is licensed according to the W3C Software License at
 *   https://www.w3.org/Consortium/Legal/2015/copyright-software-and-document
 *
 *   File:   tabs-automatic.js
 *
 *   Desc:   Tablist widget that implements ARIA Authoring Practices
 */

    'use strict';

    class TabsAutomatic {
        constructor(groupNode) {
            // Init du slider des tablists
            this.splide = new Splide(groupNode, {
                omitEnd: false,
                label: 'Horaires et dates d’ouverture',

                i18n: {
                    prev: 'Onglet précédent',
                    next: 'Onglet suivant',
                }

            });
            this.splide = this.splide.mount();

            // RGAA : suppression du aria-roledescription injecté par défaut par splide
            groupNode.removeAttribute('aria-roledescription');

            const slides = groupNode.querySelectorAll('.splide__slide');
            slides.forEach(slide => {
                slide.setAttribute('role', 'presentation');
                slide.removeAttribute('aria-roledescription');
                slide.removeAttribute('aria-label');
            });


            // Changement de slide -> active / désactive les tabs
            this.splide.on( 'active', Slide => {
                this.onSlideUpdate(Slide);
            });



            this.tablistNode = groupNode;

            this.tabs = [];

            this.firstTab = null;
            this.lastTab = null;
            this.currentTabId = null;

            this.tabs = Array.from(this.tablistNode.querySelectorAll('[role=tab]'));
            this.tabpanels = [];

            this.tabs.forEach((tab) => {
                const tabpanel = document.getElementById(tab.getAttribute('aria-controls'));

                tab.tabIndex = -1;
                tab.setAttribute('aria-selected', 'false');
                this.tabpanels.push(tabpanel);

                tab.addEventListener('keydown', this.onKeydown.bind(this));
                tab.addEventListener('click', this.onClick.bind(this));

                if (!this.firstTab) {
                    this.firstTab = tab;
                }
                this.lastTab = tab;
            });

            this.setSelectedTab(this.firstTab, false);
        }

        // Changement de slide -> active / désactive les tabs
        onSlideUpdate(slide) {
            if(slide.index !== this.currentTabId) {
                console.log('slide.index / this.currentTabId', slide.index , '/', this.currentTabId);

                const currentTab = this.tabs[slide.index ];
                this.setSelectedTab(currentTab, false);
                // console.log('currentTab', currentTab);
            }
        }




        setSelectedTab(currentTab, setFocus) {
            if (typeof setFocus !== 'boolean') {
                setFocus = true;
            }

            this.tabs.forEach((tab) => {
                const tabpanel = document.getElementById(tab.getAttribute('aria-controls'));

                if (currentTab === tab) {
                    tab.setAttribute('aria-selected', 'true');
                    tab.removeAttribute('tabindex');
                    tabpanel.classList.remove('st-is-hidden');

                    if (setFocus) {
                        tab.focus();
                    }

                    // update du slider
                    this.currentTabId = this.tabs.indexOf(tab);
                    this.splide.go(this.currentTabId);
                } else {
                    tab.setAttribute('aria-selected', 'false');
                    tab.tabIndex = -1;
                    tabpanel.classList.add('st-is-hidden');
                }
            });
        }

        setSelectedToPreviousTab(currentTab) {
            var index;

            if (currentTab === this.firstTab) {
                this.setSelectedTab(this.lastTab);
            } else {
                index = this.tabs.indexOf(currentTab);
                this.setSelectedTab(this.tabs[index - 1]);
            }
        }

        setSelectedToNextTab(currentTab) {
            if (currentTab === this.lastTab) {
                this.setSelectedTab(this.firstTab);
            } else {
                const index = this.tabs.indexOf(currentTab);
                this.setSelectedTab(this.tabs[index + 1]);
            }
        }

        /* EVENT HANDLERS */

        onKeydown(event) {
            let tgt = event.currentTarget,
                flag = false;

            switch (event.key) {
                case 'ArrowLeft':
                    this.setSelectedToPreviousTab(tgt);
                    flag = true;
                    break;

                case 'ArrowRight':
                    this.setSelectedToNextTab(tgt);
                    flag = true;
                    break;

                case 'Home':
                    this.setSelectedTab(this.firstTab);
                    flag = true;
                    break;

                case 'End':
                    this.setSelectedTab(this.lastTab);
                    flag = true;
                    break;

                default:
                    break;
            }

            if (flag) {
                event.stopPropagation();
                event.preventDefault();
            }
        }

        onClick(event) {
            this.setSelectedTab(event.currentTarget);
        }
    }

    // Initialize tablist & slider
    const sliderTabs = document.querySelectorAll('.st-js-slider-tablist');
    sliderTabs.forEach(slider => {
        new TabsAutomatic(slider);
    });

})();
