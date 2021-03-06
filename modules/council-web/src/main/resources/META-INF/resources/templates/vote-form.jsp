<%@ include file="/council-init.jsp"%>

<portlet:resourceURL id="submitVotes" var="submitVotesURL">
</portlet:resourceURL>

<!-- AFFICHAGE SEULEMENT SI L'ELU A VOTE -->
<div class="confirmation-vote" id="confirmation-vote" style="display:none;">
    <h3><liferay-ui:message key='vote.registered.find.your.recap'/></h3>
</div>

<!-- FORMULAIRE (ICI PRESENT AVEC PROCURATION) -->
<form class="vote-forms" id="vote-forms" style="display:none;">

    <input type="hidden" id="<portlet:namespace />session-id" value="" >
    <input type="hidden" id="<portlet:namespace />deliberation-id" value="" >

    <!-- Vote élu -->
    <div class="vote-form">

        <div class="vote-title">
            <liferay-ui:message key='my.vote'/>
        </div>

        <div class="vote-answers">
            <label class="answer-wrapper">
                <input type="radio" id="pour" name="<portlet:namespace />official-vote" value="Pour" >
                <span><liferay-ui:message key='vote.for'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="contre" name="<portlet:namespace />official-vote" value="Contre">
                <span><liferay-ui:message key='vote.against'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="abstention" name="<portlet:namespace />official-vote" value="Abstention">
                <span><liferay-ui:message key='vote.abstention'/></span>
            </label>
        </div>

    </div>
    <!-- END : Vote élu -->

    <!-- Vote procuration 1 -->
    <div class="vote-form" id="form-procu-1">

        <div class="vote-title" id="title-procu-1">
            Procuration <span>MARTIN Lucas</span>
        </div>

        <input type="hidden" id="<portlet:namespace />official-procuration-id-1" value="" >

        <div class="vote-answers">
            <label class="answer-wrapper">
                <input type="radio" id="pour1" name="<portlet:namespace />official-procuration-vote-1" value="Pour" >
                <span><liferay-ui:message key='vote.for'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="contre1" name="<portlet:namespace />official-procuration-vote-1" value="Contre">
                <span><liferay-ui:message key='vote.against'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="abstention1" name="<portlet:namespace />official-procuration-vote-1" value="Abstention">
                <span><liferay-ui:message key='vote.abstention'/></span>
            </label>
        </div>

    </div>
    <!-- END : Vote procuration 1 -->

    <!-- Vote procuration 2 -->
    <div class="vote-form" id="form-procu-2">

        <div class="vote-title" id="title-procu-2">
            Procuration <span>HANTOUIN Bénédicte</span>
        </div>

        <input type="hidden" id="<portlet:namespace />official-procuration-id-2" value="" >

        <div class="vote-answers">
            <label class="answer-wrapper">
                <input type="radio" id="pour2" name="<portlet:namespace />official-procuration-vote-2" value="Pour" >
                <span><liferay-ui:message key='vote.for'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="contre2" name="<portlet:namespace />official-procuration-vote-2" value="Contre">
                <span><liferay-ui:message key='vote.against'/></span>
            </label>
            <label class="answer-wrapper">
                <input type="radio" id="abstention2" name="<portlet:namespace />official-procuration-vote-2" value="Abstention">
                <span><liferay-ui:message key='vote.abstention'/></span>
            </label>
        </div>

    </div>
    <!-- END : Vote procuration 2 -->

    <!-- Messsage d'erreur -->
    <div class="error-vote-message" id="error-vote-message" style="display:none;">
        <p></p>
    </div>

    <div class="btn-validate-vote seu-btn-line">
        <button class="seu-btn-square seu-filled seu-second" title="Valider" id="vote-button-submit">
            <span class="seu-flexbox">
                <span class="seu-btn-text"><liferay-ui:message key='eu.council.web.validate'/></span>
            </span>
        </button>
    </div>

</form>

<script type="text/javascript">

    /* Lors de l'envoie du formulaire */
    $("#vote-button-submit").click(function(event){
        event.preventDefault();
        $("#vote-button-submit").hide();
        hideErrorMessage(); // Cache un potentiel précédent message d'erreur
        if (validateFormValues()){
            // Récupération des informations
            var sessionId = $("#" + namespace + "session-id").val();
            var deliberationId = $("#" + namespace + "deliberation-id").val();
            var officialId = officialConnectedId;
            var officialVote = $('input[name=' + namespace + 'official-vote]:checked').val();
            var officialProcurationId_1 = $("#" + namespace + "official-procuration-id-1").val();
            var officialProcurationVote_1 = $('input[name=' + namespace + 'official-procuration-vote-1]:checked').val();
            var officialProcurationId_2 = $("#" + namespace + "official-procuration-id-2").val();
            var officialProcurationVote_2 = $('input[name=' + namespace + 'official-procuration-vote-2]:checked').val();
            // Envoie au serveResource
            AUI().use('aui-io-request', function(A) {
                try {
                    A.io.request('${submitVotesURL}', {
                        method : 'POST',
                        dataType: 'json',
                        data:{
                            <portlet:namespace />sessionId : sessionId,
                            <portlet:namespace />deliberationId : deliberationId,
                            <portlet:namespace />officialId : officialId,
                            <portlet:namespace />officialVote : officialVote,
                            <portlet:namespace />officialProcurationId_1 : officialProcurationId_1,
                            <portlet:namespace />officialProcurationVote_1 : officialProcurationVote_1,
                            <portlet:namespace />officialProcurationId_2 : officialProcurationId_2,
                            <portlet:namespace />officialProcurationVote_2 : officialProcurationVote_2
                        },
                        on: {
                            complete: function(e) {
                                var data = JSON.parse(e.details[1].responseText);
                                if (data.result) {
                                    // Retour du serveResource avec succes
                                    showFormRecap();
                                } else {
                                    // Retour du serveResource avec erreur
                                    showErrorMessage(data.message);
                                }
                            }
                        }
                    });
                }
                catch(error) {
                    $("#vote-button-submit").show();
                    if (!(error instanceof TypeError)) {
                        console.log(error);
                    } else {
                        console.log("petite erreur sans importance")
                    }
                }
            });
        } else {
            $("#vote-button-submit").show();
        }
    });

    /* Validation des informations du formulaire */
    function validateFormValues() {
        // Si l'utilisateur à au moins valider son vote
        if ($('input[name=' + namespace + 'official-vote]:checked').length < 1
                && $('input[name=' + namespace + 'official-procuration-vote-1]:checked').length < 1
                && $('input[name=' + namespace + 'official-procuration-vote-2]:checked').length < 1) {
            showErrorMessage("<liferay-ui:message key='vote-empty-error'/>");
            return false;
        }
        return true;
    }

    /* Montre le récapitulatif de vote */
    function showFormRecap() {
        // Désactivations des inputs et du bouton de validation
        $('input[name=' + namespace + 'official-vote]').prop("disabled", true);
        $('input[name=' + namespace + 'official-procuration-vote-1]').prop("disabled", true);
        $('input[name=' + namespace + 'official-procuration-vote-2]').prop("disabled", true);
        $("#vote-button-submit").hide();
        $("#confirmation-vote").show();
    }

    /* Réinitialise le formulaire de vote */
    function resetFormValues() {
        $("#confirmation-vote").hide();
        $("#" + namespace + "deliberation-id").val(0);
        $('input[name=' + namespace + 'official-vote]').prop("disabled", false).prop('checked', false);
        $('input[name=' + namespace + 'official-procuration-vote-1]').prop("disabled", false).prop('checked', false);
        $('input[name=' + namespace + 'official-procuration-vote-2]').prop("disabled", false).prop('checked', false);
        hideErrorMessage();
        $("#vote-button-submit").show();
    }

    /* Affiche l'encart d'erreur avec le message donné */
    function showErrorMessage(message) {
        $("#error-vote-message").show();
        $("#error-vote-message").html('<p>' + message + '</p>');
    }

    /* Cache l'encart d'erreur */
    function hideErrorMessage() {
        $("#error-vote-message").hide();
        $("#error-vote-message").html('<p></p>');
    }

</script>