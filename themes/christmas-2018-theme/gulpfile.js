'use strict';

var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
var plugins = require('gulp-load-plugins')();
var del = require('del');
var runSequence = require('run-sequence').use(gulp);

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
  }
});

gulp.task('remove-maps', cb => {
	del('./build/**/*.map').then(() => cb());
});

gulp.task('remove-scss', cb => {
	del('./build/**/*.scss').then(() => cb());
});

gulp.task('css', function () {
    var source = './custom/css/';
    var destination = './src/css/';

    return gulp.src(source + '/style.scss')
    .pipe(plugins.sass({outputStyle: 'compressed'}))
    .pipe(plugins.autoprefixer())
    .pipe(gulp.dest(destination));
});

gulp.task('js', function () {
    var source = './custom/js/';
    var destination = './src/js/';

    return gulp.src([source + 'libs/*.js', source + 'src/*.js'])
    .pipe(plugins.concat('./t_main.js'))
    .pipe(gulp.dest(destination + './'))
    .pipe(plugins.uglify())
    .pipe(plugins.rename({suffix: '.min'}))
    .pipe(gulp.dest(destination));
});
