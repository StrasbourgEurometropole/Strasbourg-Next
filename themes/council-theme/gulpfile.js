'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var sass = require('gulp-sass')(require('sass'));
var plugins = require('gulp-load-plugins')({
	rename: {
		'gulp-clean-css': 'cleancss',
		'gulp-sass-import-json': 'jsonToSass',
		'gulp-ruby-sass': 'rubysass',
		'gulp-require-tasks': 'requireTask',
		'gulp-ext-replace': 'extReplace',
		'gulp-sass-glob': 'globs'
	}
});
var rename = require('gulp-rename');
var globSass = require('gulp-sass-glob-import');
var cleancss = require('gulp-clean-css');
var del = require('del');
var runSequence = require('gulp4-run-sequence');
const uglify = require('gulp-uglify');

liferayThemeTasks.registerTasks({
	gulp: gulp,
	hookFn: function(gulp) {
		gulp.task('build:r2', function(done) {
			const plugins = require('gulp-load-plugins')();

			return gulp
				.src(['./build/css/*.css','!./build/css/*_rtl.css'])
		});

		gulp.hook('after:build:move-compiled-css', function(done) {
			runSequence('remove-maps', 'remove-scss', 'remove-node-modules', done);
		})

		gulp.hook('after:build:copy:fontAwesome', function(done) {
			runSequence('remove-fonts', done);
		})
	}
});

gulp.task('remove-maps', cb => {
	del('./build/**/*.map').then(() => cb());
});

gulp.task('remove-scss', cb => {
	del('./build/**/*.scss').then(() => cb());
});

gulp.task('remove-node-modules', cb => {
	del('./build/node_modules').then(() => cb());
});

gulp.task('remove-fonts', cb => {
	del(['./build/font/fontawesome-alloy.dev.svg',
		'./build/font/fontawesome-alloy.svg']).then(() => cb());
});


gulp.task('css', function() {
	return gulp.src('./custom/council.scss')
		.pipe(globSass())
		.pipe(plugins.plumber({
			errorHandler: function (err) {
				console.log(err);
				this.emit('end');
			}
		}))
		.pipe(sass({
			sourceComments: 'map'
		}))
		.pipe(cleancss({keepBreaks: false}))
		.pipe(plugins.autoprefixer())
		.pipe(gulp.dest('./src/css/'))
});

gulp.task('js', function(){
	return gulp.src('./custom/council.js')
		.pipe(plugins.plumber())
		.pipe(plugins.include())
		.on('error', console.log)
		.pipe(uglify())
		.pipe(gulp.dest('src/js/'));
});
