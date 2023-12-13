

function isTouchDevice() {
    return 'ontouchstart' in document.documentElement;
}

function isNoHover() {
    if (isTouchDevice() && document.body.clientWidth <= thConfig.desktopBreakpoint) {
        return true;
    }
    return false;
}

function isTabletPortraitOrSmalller() {
    if (document.body.clientWidth < thConfig.tabletPortraitBreakpoint) {
        return true;
    }
    return false;
}

function isMobileOrSmaller() {
    if (document.body.clientWidth <= thConfig.mobileBreakpoint) {
        return true;
    }
    return false;
}