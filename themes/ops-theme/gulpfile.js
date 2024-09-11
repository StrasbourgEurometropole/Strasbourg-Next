'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var plugins = require('gulp-load-plugins')();
var sass = require('gulp-sass')(require('sass'));
var phpinc = require("php-include-html");
var del = require('del');
var runSequence = require('gulp4-run-sequence');

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

gulp.task('css', function () {
	return gulp.src('./custom/scss/ops.scss')
		.pipe(sass({outputStyle: 'compressed'}))
		.on('error', function (err) {
			console.log(err.toString());
			this.emit('end');
		})
		.pipe(plugins.autoprefixer())
		.pipe(gulp.dest('./src/css/'));
});

gulp.task('js', function () {
		return gulp.src(['./custom/js/config.js',
			'./custom/js/global.js',
			'./custom/js/libs/jquery*.js',
			'./custom/js/libs/*.js',
			'./custom/js/src/*.js',
			'./custom/js/src-1/*.js',
			'./custom/js/src-2/*.js',
			'./custom/js/override/*.js'])
			.pipe(plugins.concat('ops.js'))
			.on('error', function (err) {
				console.log(err.toString());
				this.emit('end');
			})
			.pipe(gulp.dest('src/js/'));
});

gulp.task('toprod', function () {
	gulp.src(['./custom/js/config.js','./custom/js/global.js','./custom/js/libs/jquery*.js','./custom/js/libs/*.js','./custom/js/src/*.js','./custom/js/src-1/*.js','./custom/js/src-2/*.js','./custom/js/src-3/*.js'])
		.pipe(plugins.concat('ops.js'))
		.on('error', function (err) {
			console.log(err.toString());
			this.emit('end');
		})
		// .pipe(gulp.dest(destination + '_js/'))
		.pipe(gulp.dest('./dist/'))
		.pipe(plugins.uglify())
		.pipe(plugins.rename({suffix: '.min'}))
		.pipe(gulp.dest('./dist/'));

	gulp.src(['!./js/libs/jquery.js','./js/libs/jquery*.js','./js/libs/*.js','./js/src-1/*.js','./js/src-2/*.js','./js/src-3/*.js','./js/**/*.js','./js/*.js'])
		.pipe(plugins.concat('main-panier.js'))
		.on('error', function (err) {
			console.log(err.toString());
			this.emit('end');
		})
		// .pipe(gulp.dest(destination + '_js/'))
		.pipe(gulp.dest('./dist/'))
		.pipe(plugins.uglify())
		.pipe(plugins.rename({suffix: '.min'}))
		.pipe(gulp.dest('./dist/'));

	gulp.src('./scss/style.scss')
		.pipe(sass({outputStyle: 'compressed'}))
		.on('error', function (err) {
			console.log(err.toString());
			this.emit('end');
		})
		.pipe(plugins.autoprefixer())
		.pipe(gulp.dest('./dist/'));

	return true;
});
