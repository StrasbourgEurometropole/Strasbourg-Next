
document.addEventListener('DOMContentLoaded', function() {
  // remove role="main" from id="main-content" to avoid duplicate role. Wait until the dom is loaded
  var mainContent = document.getElementById('main-content');
  if (mainContent) {
    mainContent.removeAttribute('role');
  }

  // get element with main tag
  const mainElement = document.querySelector('main');
  if(mainElement) {
    mainElement.id = 'main-zone';
    mainElement.setAttribute('role', 'main');
  }


});