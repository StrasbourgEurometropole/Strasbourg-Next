
function main() {
  if (configuration.id == null || configuration.id == "") {
    if (layoutMode === 'edit') {
      document.querySelector('.st-bloc-video .st-container .error-message').removeAttribute('hidden');
    }
  }
}

main();
