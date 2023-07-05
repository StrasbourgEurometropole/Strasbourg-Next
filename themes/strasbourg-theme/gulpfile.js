/**
 * © 2017 Liferay, Inc. <https://liferay.com>
 *
 * SPDX-License-Identifier: MIT
 */

'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var uglify = require('gulp-uglify');
const concat = require('gulp-concat');
var sourcemaps = require('gulp-sourcemaps');

/** Gestion de erreurs */
function onError(err) {
	console.log(err.toString());
	this.emit('end');
}


liferayThemeTasks.registerTasks({
	gulp,
	sassOptions: {
		quietDeps: true
	},
	hookFn: function(gulp) {
		gulp.hook('before:build:war', function(done) {
			// Fires before build `war` task
			gulp.src([
					'./build/js/libs/jquery.js',
					'./build/js/libs/moment.min.js',
					'./build/js/libs/*.js',
					'./build/js/libs/**/*.js',
				    './build/js/templates/*.js',
					'./build/js/*.js',
					'./build/js/**/*.js',

				]
			)
				.pipe(sourcemaps.init())
				.pipe(concat("strasbourg.min.js")).on('error', onError)
				.pipe(sourcemaps.write('./build/js'))
				.pipe(gulp.dest('./build/js/'))
				.on('end', done);
		});

	}
});
