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
const sassGlob = require('gulp-sass-glob');
var runSequence = require('gulp4-run-sequence').use(gulp);
var postcss = require('gulp-postcss');
var cleancss = require('gulp-clean-css');

/** Gestion de erreurs */
function onError(err) {
	console.log(err.toString());
	this.emit('end');
}


liferayThemeTasks.registerTasks({
	gulp,
	sassOptions: {
		quietDeps: true,
		sassOptions: {
			quietDeps: true,
		},
	},
	hookFn: function(gulp) {
		gulp.task('sassGlob', function() {
			return gulp
				.src('./build/_css/*.scss')
				.pipe(sassGlob())
				.pipe(gulp.dest('./build/_css/'));
		});
		gulp.task('compressCss', function() {
			return gulp
				.src('./build/_css/*.css')
				.pipe(cleancss({keepBreaks: false}))
				.pipe(gulp.dest('./build/_css/'));
		})
		gulp.hook('before:build:compile-css', function(done) {
			runSequence('sassGlob', done);
		});
		gulp.hook('before:build:move-compiled-css', function(done) {
			runSequence('compressCss', done);
		});
		gulp.hook('before:build:war', function(done) {
			// Fires before build `war` task
			gulp.src([
					'build/js/libs/moment.min.js',
				'build/js/libs/splide.min.js',
					'build/js/libs/*.js',
					'build/js/libs/**/*.js',
					'build/js/*.js',
					'build/js/**/*.js',
				]
			)

				.pipe(concat("strasbourg.min.js")).on('error', onError)
				.pipe(gulp.dest('./build/js'))
				.on('end', done);
		});

	}
});
