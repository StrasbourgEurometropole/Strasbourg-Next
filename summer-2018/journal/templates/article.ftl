<#setting locale = locale />

<script>
    description = '${catcher.data?replace("<[^>]*>", "", "r")?html?js_string}';
</script>

<!-- Détail article -->
<div class="mns-fck mns-bloc-article container mns-p50">
    <div>
    	<div class="mns-wrapper-title">
	        <h1 class="mns-title">
	            ${title.data}
	        </h1>
        </div>
        <div class="mns-catcher">
            ${catcher.data}
        </div>
    </div>
    ${text.data}
</div>