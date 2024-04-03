<%@ include file="/init.jsp"%>
<strasbourg-picker:slider name="classPK_${param.index}" value="${param.classPK}" />

<div class="buttons">
    <clay:button icon="move" cssClass="move vignette-move" small="true">

    </clay:button>

    <clay:button icon="trash" cssClass="vignette-delete" small="true" data-index="${param.index}">

    </clay:button>
</div>