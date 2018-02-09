<script>
    window.tipiURL = '${tipiURL.getData()}';
    window.tipiCallbackURL = '${tipiCallbackURL.getData()}';
</script>

<section id="bills">
    <h2><@liferay.language key="pay-my-bills" /></h2>
    <form id="formFactures" action="" class="generic-form toValidate">
        <p>${text.getData()}</p> 
        <p class="errors"></p>      
        <div class="webform-layout-box">
            <div class="form-group">
                <div class="form-label"><label for="annee"><@liferay.language key="bill-type" /><strong class="required">*</strong></label></div>
                <div class="form-field">
                    <select id="type_facture" required="" aria-required="true">
                        <option value="" label='' />
                        <option value="childhood" label='<@liferay.language key="childhood" />' />
                        <option value="schoolRestaurant" label='<@liferay.language key="school-restaurant" />' />
                        <option value="afterSchool" label='<@liferay.language key="after-school" />' />
                        <option value="water" label='<@liferay.language key="water" />' />
                    </select>
                </div>
            </div>
        </div>

        <div class="webform-layout-box">
            <div class="form-group">
                <div class="form-label"><label for="annee"><@liferay.language key="year" /><strong class="required">*</strong></label></div>
                <div class="form-field">
                    <input type="number" id="year" required="" aria-required="true" placeholder='<@liferay.language key="year" />...'>
                </div>
            </div>

            <div class="form-group">
                <div class="form-label"><label for="bill_id"><@liferay.language key="bill-number" /><strong class="required">*</strong></label></div>
                <div class="form-field">
                    <input type="number" id="ref" required="" aria-required="true" placeholder='<@liferay.language key="your-bill-numer" />...'>
                </div>
            </div>
        </div>
        <div class="webform-layout-box">
            <div class="form-group">
                <div class="form-label"><label for="bill_mail"><@liferay.language key="email" /><strong class="required">*</strong></label></div>
                <div class="form-field">
                    <input type="email" id="email" required="" aria-required="true"  placeholder='<@liferay.language key="your-email" />...'>
                </div>
            </div>

            <div class="form-group">
                <div class="form-label"><label for="bill_amount"><@liferay.language key="amount" /><strong class="required">*</strong></label></div>
                <div class="form-field">
                    <input type="number" value="1000.00" min="0" required="" aria-required="true"  id="amount" name="bill_amount" />
                </div>
            </div>
        </div>
        <button type="submit" class="btn-square--bordered--core"><span class="flexbox"><span class="btn-text"><@liferay.language key="pay" /></span><span class="btn-arrow"></span></span></button>
    </form>
</section>

<style>
    #bills .errors {
        color: red;
    }
</style>