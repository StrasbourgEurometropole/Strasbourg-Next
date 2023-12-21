// Please refer to https://github.com/liferay/liferay-portal/tree/master/modules/apps/fragment/fragment-collection-contributor/fragment-collection-contributor-basic-component/src/main/resources/com/liferay/fragment/collection/contributor/basic/component/dependencies/external-video for more info

let content = null;
let errorMessage = null;
let loadingIndicator = null;
let resizeIntervalId = null;
let videoContainer = null;
let videoMask = null;
let maskVideo = null;
let transcriptVideo = null;

let videoContainerHtml = null;

const editMode = layoutMode === 'edit';

const height = configuration.videoHeight
	? configuration.videoHeight.replace('px', '')
	: configuration.videoHeight;

const width = configuration.videoWidth
	? configuration.videoWidth.replace('px', '')
	: configuration.videoWidth;

function debounce(fn, timeout) {
	let timeoutId = null;

	return function () {
		clearTimeout(timeoutId);

		timeoutId = setTimeout(fn, timeout);
	};
}

function main() {
	clearInterval(resizeIntervalId);
	window.removeEventListener('resize', resize);

	if (!document.body.contains(fragmentElement)) {
		return;
	}

	content = fragmentElement.querySelector('.st-bloc-video .st-container');

	if (!content) {
		return requestAnimationFrame(main);
	}

	errorMessage = content.querySelector('.error-message');
	loadingIndicator = content.querySelector('.loading-animation');
	videoContainer = content.querySelector('.st-embed-container');
	videoMask = content.querySelector('.video-mask');
	maskVideo = content.querySelector('.st-mask-video');

	try {
		if (configuration.video) {
			const videoConfiguration = JSON.parse(configuration.video);
			if (videoConfiguration.html) {
				videoContainerHtml = videoConfiguration.html;
				maskVideo.classList.remove("st-hide");
        		videoContainer.classList.remove("st-hide");
				maskVideo.addEventListener("click", () => { videoContainer.innerHTML = videoContainerHtml })
				let title = videoConfiguration.title;
				// check if urlVideo is a DAILYMOTION video
				if (videoContainerHtml.includes("dailymotion")) {
					// get the attribute data-thumbnail from videoContainerHtml
					let thumbnail = videoContainerHtml.match(/data-thumbnail="([^"]*)/) ? videoContainerHtml.match(/data-thumbnail="([^"]*)/)[1] : "";
					// put the thumbnail in the maskVideo
					let image = maskVideo.querySelector("img");
					image.src = thumbnail;
					// add autoplay=1 to the url of the iframe in videoContainerHtml
					videoContainerHtml = videoContainerHtml.replace(/autoplay=0/g, "autoplay=1");
					// add the title to the maskVideo
					maskVideo.querySelector("p.st-surtitre").innerHTML = title;
				}
				else {
					// remove maskVideo from dom
					maskVideo.parentElement.removeChild(maskVideo);

				}
				requestAnimationFrame(showVideo);
			}
			else {
				showError();
			}
		}
		else {
			showError();
		}
	}
	catch (error) {
		console.error(error);
		showError();
	}
}

const resize = debounce(function () {
	if (!document.body.contains(fragmentElement)) {
		clearInterval(resizeIntervalId);
		window.removeEventListener('resize', resize);

		return;
	}

	const scrollPosition = {
		left: window.scrollX,
		top: window.scrollY,
	};

	content.style.height = '';
	content.style.width = '';

	requestAnimationFrame(function () {
		try {
			const boundingClientRect = content.getBoundingClientRect();

			const contentWidth = width || boundingClientRect.width;

			const contentHeight = height || contentWidth * 0.5625;

			content.style.height = contentHeight + 'px';
			content.style.width = contentWidth + 'px';

			window.scrollTo(scrollPosition);
		}
		catch (error) {
			clearInterval(resizeIntervalId);
			window.removeEventListener('resize', resize);
		}
	});
}, 300);

function showError() {
	if (editMode) {
		errorMessage.removeAttribute('hidden');
		loadingIndicator.parentElement.removeChild(loadingIndicator);
		videoContainer.parentElement.removeChild(videoContainer);
	}
	else {
		fragmentElement.parentElement.removeChild(fragmentElement);
	}
}

function showVideo() {
	errorMessage.parentElement.removeChild(errorMessage);
	loadingIndicator.parentElement.removeChild(loadingIndicator);
	videoContainer.removeAttribute('aria-hidden');

	if (!editMode) {
		videoMask.parentElement.removeChild(videoMask);
	}

	window.addEventListener('resize', resize);

	if (editMode) {
		resizeIntervalId = setInterval(resize, 2000);
	}

	resize();
}

main();
