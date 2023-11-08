@echo off
set "sourceCSSDir=C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\css"
set "overridePattern=_custom.scss"
set "destinationCSSDir=C:\liferay\sf-strasbourgeu-mockup\assets\scss"

set "sourceJSDir=C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\js"
set "destinationJSDir=C:\liferay\sf-strasbourgeu-mockup\assets\js"

set "sourceImagesDir=C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\images"
set "destinationImagesDir=C:\liferay\sf-strasbourgeu-mockup\assets\images"

set "sourceFontsDir=C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\fonts"
set "destinationFontsDir=C:\liferay\sf-strasbourgeu-mockup\assets\fonts"

REM Delete everything in sourceCSSDir except override_*.scss
echo Deleting files in %sourceCSSDir% except %overridePattern%...

for /r "%sourceCSSDir%" %%A in (*) do (
    if not "%%~nxA" == "_custom.scss" (
    if not "%%~nxA" == "_clay_variables.scss" (
            del "%%A"
        )
    )
)
for /d /r "%sourceCSSDir%" %%D in (*) do (
    rmdir "%%D" /s /q 2>nul
)

REM Copy everything from the destinationCSSDir to sourceCSSDir
echo Copying files from %destinationCSSDir% to %sourceCSSDir%...
xcopy /s /y "%destinationCSSDir%\*" "%sourceCSSDir%"

REM Add the new CSS files to git
cd /d "%sourceCSSDir%"
git add .


for /r "%sourceJSDir%" %%A in (*) do (
    if not "%%~nxA" == "alert.js" (
    if not "%%~nxA" == "favorite.js" (
            if not "%%~nxA" == "map.js" (
                        del "%%A"
                    )
        )
    )
)
for /d /r "%sourceJSDir%" %%D in (*) do (
if not "%%~nxD" == "custom" (
            rmdir "%%D" /s /q 2>nul
        )

)

REM Copy everything from the destinationJSDir to sourceJSDir
echo Copying files from %destinationJSDir% to %sourceJSDir%...
xcopy /s /y "%destinationJSDir%\*" "%sourceJSDir%"

REM Add the new JS files to git
cd /d "%sourceJSDir%"
git add .

REM Delete the content of sourceImagesDir
echo Deleting files in %sourceImagesDir%...
del /q "%sourceImagesDir%\*" >nul 2>&1

REM Copy everything from the destinationImagesDir to sourceImagesDir
echo Copying files from %destinationImagesDir% to %sourceImagesDir%...
xcopy /s /y "%destinationImagesDir%\*" "%sourceImagesDir%"

REM Add the new image files to git
cd /d "%sourceImagesDir%"
git add .

REM Delete the content of sourceFontsDir
echo Deleting files in %sourceFontsDir%...
del /q "%sourceFontsDir%\*" >nul 2>&1

REM Copy everything from the destinationFontsDir to sourceFontsDir
echo Copying files from %destinationFontsDir% to %sourceFontsDir%...
xcopy /s /y "%destinationFontsDir%\*" "%sourceFontsDir%"

REM Add the new font files to git
cd /d "%sourceFontsDir%"
git add .

REM Copy favicon.ico and logo.png
copy /y "C:\liferay\sf-strasbourgeu-mockup\assets\images\favicon\favicon.ico" "C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\images\favicon.ico"
copy /y "C:\liferay\sf-strasbourgeu-mockup\assets\images\medias\logo.png" "C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\images\thumbnail.png"

REM Add the new favicon.ico and thumbnail.png to git
cd /d "C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\images"
git add favicon.ico thumbnail.png

echo All tasks completed successfully.
pause
