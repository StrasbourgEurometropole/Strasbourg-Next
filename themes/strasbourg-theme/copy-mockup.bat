@echo off
set "sourceDir=C:\liferay\ems-workspace\Strasbourg-Next\themes\strasbourg-theme\src\css"
set "overridePattern=override_*.scss"
set "destinationDir=C:\liferay\sf-strasbourgeu-mockup\assets\scss"

REM Delete everything in sourceDir except override_*.scss
echo Deleting files in %sourceDir% except %overridePattern%...
for /f "delims=" %%f in ('dir /b /a-d "%sourceDir%\*.scss" ^| findstr /v /i /e /c:"%overridePattern%"') do (
    del "%sourceDir%\%%f" >nul 2>&1
)

REM Copy everything from the destinationDir to sourceDir
echo Copying files from %destinationDir% to %sourceDir%...
xcopy /s /y "%destinationDir%\*" "%sourceDir%"

REM Add the new files to git
cd /d "%sourceDir%"
git add .

echo Task completed successfully.
pause