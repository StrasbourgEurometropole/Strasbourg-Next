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
var del = require('del');
var runSequence = require('gulp4-run-sequence').use(gulp);

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


gulp.task('css', function() {
  return gulp.src('./custom/strasbourg.scss')
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
    .pipe(plugins.autoprefixer())
    .pipe(gulp.dest('./src/css/'))
});

gulp.task('js', function(){
    return gulp.src('./custom/strasbourg.js')
        .pipe(plugins.plumber())
        .pipe(plugins.include())
        .on('error', console.log)
        .pipe(gulp.dest('src/js/'));
});