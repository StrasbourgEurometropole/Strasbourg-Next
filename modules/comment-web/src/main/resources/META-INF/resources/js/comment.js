addResult = function () {
    var start = document.getElementById('nb-results').value;
    var postData = `${porletNamespace}start=` + start;

    addComment(addCommentsURL, postData);
}

function addComment(url, data) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                addCommentList(JSON.parse(xhr.responseText));
            }
            // Remove the "loading" class when the request is complete
            document.querySelector('#resultList .loading-animation')?.classList.add('hide');

            // update aria-busy to false
            document.querySelector('#resultList').setAttribute("aria-busy", "false");
        } else {
            // Add the "loading" class when the request is loading
            document.querySelector('#resultList .loading-animation')?.classList.remove('hide');

            // update aria-busy to true
            document.querySelector('#resultList').setAttribute("aria-busy", "true");
        }
    };
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);
}

function addCommentList(data) {
    var action = document.getElementById('action');
    var seeMore = document.getElementById('see-more');
    var totalResults = document.getElementById('total-results').value;
    var nbResults = document.getElementById('nb-results');

    var displayResult = parseInt(data.displayResult, 10);
    nbResults.value = displayResult;
    if(totalResults > displayResult) {
        seeMore.style.display = "inline-block";
    }else {
        seeMore.style.display = "none"
    }

    data.comments.forEach(function (item) {
        if(item.text) {
            item.text = item.text.replace(/(<([^>]+)>)/ig,"");
        }
        var vignette = createVignette(item);
        if(vignette != "") {
            action.insertAdjacentHTML('beforebegin', vignette);
        }
    });
}

function createVignette(comment) {
    if(hideCommentURL != '')
        hideComment = hideCommentURL + `&${porletNamespace}commentId=${comment.commentId}`;
    var vignette = `
    <div id="${comment.commentId}" class="pro-item">

        <div class="pro-txt">
            <div class="comment-main-block">
                <div class="comment-header">
                    <figure role="group">
                        <img src="${comment.imageURLOrSurrogate}" alt="Photo de profil" width="50" height="50" class="fit-cover"/>
                    </figure>
                    <div class="comment-header-author">
                        <div>
                            <span class="pro-name">${comment.publikUserName}</span>
                            ${comment.userQuality ? `<span class="pro-fonction">${comment.userQuality}</span>` : ''}
                        </div>
                        <div>
                            <span class="pro-comment-time">` +
                                Liferay.Language.get('comment-published') +
                                ` ${comment.createDate}
                            </span>
                        </div>
                    </div>
                    <div class="pro-interactions">`;
                        if (isAssetCommentable && !isUserBanned && hasUserSigned) {
                            vignette += `<a href="#pro-avis-like-pro" class="pro-like"
                               data-typeid="16"
                               data-isdislike="false"
                               data-title="Comment of ${comment.publikUserName}"
                               data-entityid="${comment.commentId}"
                               data-entitygroupid="${comment.groupId}"
                               title="Approuver ce commentaire">
                                ${comment.nbLikes}
                            </a>
                            <a href="#pro-avis-dislike-pro" class="pro-dislike"
                               data-typeid="16"
                               data-isdislike="true"
                               data-title="Comment of ${comment.publikUserName}"
                               data-entityid="${comment.commentId}"
                               data-entitygroupid="${comment.groupId}"
                               title="Desapprouver ce commentaire">
                                ${comment.nbDislikes}
                            </a>
                            <div class="pro-action-link">
                                <a href="#Repondre" class="pro-reponse" onClick="repondre(this);"
                                   data-commentid="${comment.commentId}"
                                   data-username="${comment.publikUserName}"
                                   title="Repondre au commentaire">` +
                                    Liferay.Language.get('comment-answer') +
                                `</a>
                                <a href="#report" onClick="signaler(this);"
                                   title="Signaler le commentaire"
                                   data-commentid="${comment.commentId}">` +
                                    Liferay.Language.get('comment-report') +
                                `</a>
                                ${isAdmin ? `<a href="${hideComment}" title="Masquer le commentaire">`+Liferay.Language.get('comment-hide')+`</a>` : ''}
                            </div>`;
                            if(userPublikId == comment.publikId){
                                vignette += `<div class="pro-action-comm">
                                    <a href="#Modifier" onClick="update(this);"
                                       data-commentid="${comment.commentId}"
                                       title="Modifier mon commentaire">
                                        <span class="icon-ico-modifier"></span>
                                    </a>
                                    <a href="#Supprimer" onClick="deleteComment(this);"
                                       title="Supprimer mon commentaire"
                                       data-commentid="${comment.commentId}">
                                        <span class="icon-ico-remove"></span>
                                    </a>
                                </div>`;
                            }
                        }else{
                            vignette += `<a class="pro-like" data-toggle="modal" data-target="#myModal">${comment.nbLikes}</a>
                            <a class="pro-dislike" data-toggle="modal" data-target="#myModal">${comment.nbDislikes}</a>`;
                            if(isAdmin){
                                vignette += `<div class="pro-action-link">
                                    <a href="${hideComment}" title="Masquer le commentaire">` +
                                        Liferay.Language.get('comment-hide') +
                                    `</a>
                                </div>`;
                            }
                        }
                    vignette += `</div>
                </div>

                <div class="pro-comment">
                    <p id="comment-${comment.commentId}">${comment.text}</p>
                </div>
                
                ${comment.modifiedByUserDate ? `<p class="pro-label-edition">`+Liferay.Language.get('comment-edited-on')+
                        `${comment.modifiedByUserDate} `+Liferay.Language.get('comment-edited-at')+
                        `${comment.modifiedByUserHour}</p>` : '' }
            </div>`;

            comment.approvedChildComments.forEach(function (commentAnswer) {
                if(hideCommentURL != '')
                    hideComment = hideCommentURL + `&${porletNamespace}commentId=${commentAnswer.commentId}`;
                if(commentAnswer.text) {
                    commentAnswer.text = commentAnswer.text.replace(/(<([^>]+)>)/ig,"");
                }
                vignette += `<div class="pro-comment-response">
                    <div>
                        <div class="comment-header">
                            <div class="pro-interactions">`;
                                if (isAssetCommentable && !isUserBanned && hasUserSigned){
                                    vignette += `<div class="pro-action-link">
                                        <a href="#report" onClick="signaler(this);" title="Signaler le commentaire" data-commentid="${commentAnswer.commentId}">` +
                                            Liferay.Language.get('comment-report') +
                                        `</a>
                                        ${isAdmin ? `<a href="${hideComment}" title="Masquer le commentaire">`+Liferay.Language.get('comment-hide')+`</a>` : ''}
                                    </div>`;
                                    if (userPublikId == commentAnswer.publikId) {
                                        vignette += `<div class="pro-action-comm">
                                            <a href="#Modifier" data-commentid="${commentAnswer.commentId}" onClick="update(this);">
                                                <span class="icon-ico-modifier"></span>
                                            </a>
                                            <a href="#Supprimer" onClick="deleteComment(this);"
                                               data-commentid="${commentAnswer.commentId}">
                                                <span class="icon-ico-remove"></span>
                                            </a>
                                        </div>`;
                                    }
                                }else{
                                    vignette += `<div class="pro-action-link">
                                        ${isAdmin ? `<a href="${hideComment}" title="Masquer le commentaire">`+Liferay.Language.get('comment-hide')+`</a>` : ''}
                                    </div>`;
                                }
                            vignette += `</div>
                            <div class="comment-header-author reply-author">
                                <strong>${commentAnswer.publikUserName}</strong>
                                <span>` +
                                    Liferay.Language.get("comment-answered") +
                                    `${commentAnswer.createDate}
                                </span>
                            </div>
                            <figure role="group">
                                <img src="${commentAnswer.imageURLOrSurrogate}"
                                     alt="Photo de profil" width="45" height="45" class="fit-cover"/>
                            </figure>
                        </div>
                    </div>

                    <div id="${commentAnswer.commentId}" class="pro-comment">
                        <p id="comment-${commentAnswer.commentId}">${commentAnswer.text}</p>`;
                        if (commentAnswer.modifiedByUserDate != undefined && commentAnswer.modifiedByUserDate != "") {
                            vignette += `<p class="pro-label-edition">` +
                                Liferay.Language.get('comment-edited-on')+`${commentAnswer.modifiedByUserDate} ` +
                                Liferay.Language.get('comment-edited-at')+`${commentAnswer.modifiedByUserHour}
                            </p>`;
                        }
                vignette += `</div>
                </div>`;
            });
    vignette += `</div>
    </div>`;
    return vignette;
}


function signaler(elt){
    var commentId=elt.attributes['data-commentid'].value;
    $("input[id='commentId']").val(commentId);
    $("#modalSignaler").modal();
}

function deleteComment(elt){
    var commentId=elt.attributes['data-commentid'].value;
    $("input[id='commentId']").val(commentId);
    $("#modalSupprimer").modal();
}

function repondre(elt){
    var OPName = elt.attributes['data-username'].value;
    var parentId = elt.attributes['data-commentid'].value;

    $("input[id='parentCommentId']").val(parentId);
    $("input[id='editCommentId']").val(0);
    $(".pro-reagir .pro-textearea>textarea").text("");
    $(".pro-reagir .pro-textearea>input").show();
    $("label[for='inQualityOf']").show();
    $("label[for='message']").text(Liferay.Language.get("comment-parent-answer") + ' ' + OPName + ' :');
    $(".pro-reagir .pro-user-connected>.pro-btn-yellow").val(Liferay.Language.get("comment-answer"));

    $(document).scrollTop($("#pro-link-commentaire").offset().top);
}

function update(elt){
    var commentId = elt.attributes['data-commentid'].value;
    var baseMsg = $("p[id=comment-" + commentId + "]").text();

    $("input[id='editCommentId']").val(commentId);
    $("input[id='parentCommentId']").val(0);
    $(".pro-reagir .pro-textearea>textarea").text(baseMsg);
    $(".pro-reagir .pro-textearea>textarea").focus();
    $(".pro-reagir .pro-textearea>input").hide();
    $("label[for='inQualityOf']").hide();
    $("label[for='message']").text(Liferay.Language.get("comment-edit-comment"));
    $(".pro-reagir .pro-user-connected>.pro-btn-yellow").val(Liferay.Language.get("comment-edit"));

    $(document).scrollTop($("#pro-link-commentaire").offset().top);
}