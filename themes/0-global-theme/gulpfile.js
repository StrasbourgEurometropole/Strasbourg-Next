/**
 * © 2017 Liferay, Inc. <https://liferay.com>
 *
 * SPDX-License-Identifier: MIT
 */

'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var del = require('del');
var runSequence = require('gulp4-run-sequence');
var uglify = require('gulp-uglify');
var cleancss = require('gulp-clean-css');

liferayThemeTasks.registerTasks({
	gulp: gulp,
	hookFn: function(gulp) {
		gulp.task('build:r2', function(done) {
			const plugins = require('gulp-load-plugins')();

			return gulp
				.src(['./build/css/*.css','!./build/css/*_rtl.css'])
		});
		gulp.hook('after:build:move-compiled-css', function(done) {
			runSequence('remove-maps', 'remove-scss', done);
		})
		gulp.hook('before:build:war', function(done) {
			// Fires before build `war` task
			gulp.src([
					'build/css/tarteaucitron.css',
					'build/libs/tarteaucitron/css/tarteaucitron.css'
				], { base: "." }
			)
				.pipe(cleancss({compatibility: 'ie8'}))
				.pipe(gulp.dest('./'))
				.on('end', done);

			gulp.src([
					'build/js/tarteaucitron.init.js',
					'build/libs/tarteaucitron/*.js'
				], { base: "." }
			)
				.pipe(uglify())
				.pipe(gulp.dest('./'))
				.on('end', done);
		});
	}
});

gulp.task('remove-maps', cb => {
	del('./build/**/*.map').then(() => cb());
});

gulp.task('remove-scss', cb => {
	del('./build/**/*.scss').then(() => cb());
});
