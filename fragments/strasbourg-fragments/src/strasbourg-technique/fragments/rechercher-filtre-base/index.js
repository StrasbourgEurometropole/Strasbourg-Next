function handleSubmit (event) {
  // Prevent the default form submission
  event.preventDefault();

  // Get the form element by its ID
  const form = event.currentTarget.form;

  // Get the value of the "q" input
  const qValue = form.querySelector('input[name="q"]').value;

  // Get all input elements with the name "category"
  const categoryInputs = form.querySelectorAll('select[name="category"]');

  // Initialize an array to store category values
  const categoryValues = [];

  // Loop through the category inputs and collect their non-empty values
  categoryInputs.forEach(input => {
    const categoryValue = input.value.trim(); // Trim whitespace
    if (categoryValue !== '') {
      categoryValues.push(categoryValue);
    }
  });

  // Get the current URL's search parameters
  const urlSearchParams = new URLSearchParams(document.location.search);

  // Update or add the "q" parameter
  urlSearchParams.set('q', qValue);

  // Remove any existing "category" parameters
  urlSearchParams.delete('category');

  // Add the new "category" parameters
  categoryValues.forEach(value => {
    urlSearchParams.append('category', value);
  });

  // Construct the new URL with updated search parameters
  const newSearch =  "?" + urlSearchParams.toString();

  // Update the document's location with the new URL
  document.location.search = newSearch;
}

console.log("test")