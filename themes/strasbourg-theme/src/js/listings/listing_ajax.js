class thListingAjax {

    lastCall;
    listingManager;

    constructor(listingManager) {
        this.listingManager = listingManager;
    }

    call(url, ignoreHistory) {

        if (!ignoreHistory) {
            this.historyAdd(url);
        }
        this.lastCall = new Date().getTime();
        //fm.async(fm.ajax.updateActions);
        this.get(this.lastCall, url);
    }

    get(queryTime, url) {
        $.get(url, (responseHTML) => {
            if (queryTime == this.lastCall) {
                this.listingManager.handleResponse(responseHTML);
            }
        });
    }

    historyAdd(url) {
        if (typeof window.history != "undefined" && window.history.pushState) {
            window.history.pushState("", "", url);
        } else {
            document.location.href = url;
        }
    }

}