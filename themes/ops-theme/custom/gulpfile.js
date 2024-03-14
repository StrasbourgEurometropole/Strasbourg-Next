var gulp = require('gulp');
var plugins = require('gulp-load-plugins')();

var pump = require("pump");
var phpinc = require("php-include-html");
var phpFiles = ["./../*.php"];

var source = './';
var destination = './';

gulp.task('css', function () {
    return gulp.src('./scss/style.scss')
        .pipe(plugins.sass({outputStyle: 'compressed'}))
        .on('error', function (err) {
            console.log(err.toString());
            this.emit('end');
        })
        .pipe(plugins.autoprefixer())
        .pipe(gulp.dest('./dist/'));
});

gulp.task('js', function () {
    setTimeout(function() {
        return gulp.src(['./js/config.js','./js/global.js','./js/libs/jquery.js','./js/libs/jquery*.js','./js/libs/*.js','./js/src/*.js','./js/src-1/*.js','./js/src-2/*.js','./js/src-3/*.js','./js/override/*.js'])
            .pipe(plugins.concat('main.js'))
            .on('error', function (err) {
                console.log(err.toString());
                this.emit('end');
            })
            //.pipe(gulp.dest(destination + '_js/'))
            //.pipe(plugins.uglify())
            //.on('error', function (err) {
            //    console.log(err.toString());
            //    this.emit('end');
            //})
            .pipe(gulp.dest('./dist/'));
        //.pipe(plugins.uglify())
        //.pipe(plugins.rename({suffix: '.min'}))
        //.pipe(gulp.dest('./dist/'));
    },1000);
});

gulp.task('toprod', function () {
    gulp.src(['./js/config.js','./js/global.js','./js/libs/jquery.js','./js/libs/jquery*.js','./js/libs/*.js','./js/src/*.js','./js/src-1/*.js','./js/src-2/*.js','./js/src-3/*.js'])
        .pipe(plugins.concat('main.js'))
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
        .pipe(plugins.sass({outputStyle: 'compressed'}))
        .on('error', function (err) {
            console.log(err.toString());
            this.emit('end');
        })
        .pipe(plugins.autoprefixer())
        .pipe(gulp.dest('./dist/'));

    return true;
});

gulp.task('watch', function () {
    gulp.watch('./scss/**/*.scss', ['css']);
    gulp.watch(['./js/**/*.js','./js/*.js'], ['js']);
});

gulp.task('default', ['watch']);


gulp.task("php",function(cb) {
    pump([
        gulp.src(phpFiles),
        phpinc({verbose:true}),
        gulp.dest("build")
    ],cb);
});