class thListingPagination {

    options = {
        selectorpagination: null,
        selectorpaginationOverlay: null,
        selectorpaginationLight: null,
    };

    listingManager;

    constructor(options, listingManager) {

        this.listingManager = listingManager;

        options = $.extend(true, this.options, options);
        this.options = options;

        this.parse();
    }

    parse() {

        var listingManager = this.listingManager;

        $('a', this.options.selectorpagination).on('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            listingManager.ajaxCall(this.getAttribute('href'), true);
        });

        $('a', this.options.selectorpaginationOverlay).on('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            listingManager.ajaxCall(this.getAttribute('href'), true);
        });
    }

    update(html) {

        // pagination classique en bas du listing
        var pagination = $(html).find(this.options.selectorpagination).html();
        if (typeof pagination === 'undefined') {
            pagination = '';
        }

        $(this.options.selectorpagination).html(pagination);

        // Si pagination dans l'overlay map
        var paginationOverlay = $(html).find(this.options.selectorpaginationOverlay).html();
        if (typeof paginationOverlay === 'undefined') {
            paginationOverlay = '';
        }

        $(this.options.selectorpaginationOverlay).html(paginationOverlay);

        this.parse();

        if (this.options.selectorpaginationLight) {
            var paginationlight = $(html).find(this.options.selectorpaginationLight).html();
            if (typeof paginationlight === 'undefined') {
                paginationlight = '';
            }
            if (paginationlight) {
                $(this.options.selectorpaginationLight).html(paginationlight);
            }
        }
    }
}