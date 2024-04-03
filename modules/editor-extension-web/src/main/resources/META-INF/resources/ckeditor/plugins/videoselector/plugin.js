(function() {
  var STR_VIDEO_ENTRY_RETURN_TYPE =
    "com.liferay.item.selector.criteria.URLItemSelectorReturnType";

  var TPL_VIDEO =  '   <div class="seu-wi seu-media seu-wi-embed">  '  + 
                   '       <div class="seu-media-container">  '  + 
                   '           <div class="seu-media-left"><div class="seu-media-picto"></div></div>  '  + 
                   '           <div class="seu-media-right">  '  + 
                   '               <div class="seu-media-text">  '  + 
                   '                   <div class="seu-media-title">{title}</div>  '  + 
                   '                   <p class="seu-media-description">{description}</p>  '  + 
                   '               </div>  '  + 
                   '           </div>  '  + 
                   '           <div class="seu-media-bottom">  '  + 
                   '               <div class="seu-media-ratio">  '  + 
                   '                   {player}  '  + 
                   '               </div>  '  + 
                   '           </div>  '  + 
                   '       </div>  '  + 
                   '  </div>  ' ; 

  CKEDITOR.plugins.add("videoselector", {
    init: function(editor) {
      var instance = this;

      // CSS
      editor.addContentsCss(instance.path + 'assets/videoselector.css');

      // On enregistre le widget
      editor.widgets.add('videoselector', {
        // Contenu minimum du widget
        requiredContent: 'div(seu-wi-embed)',
        // Champs du widget
        editables: {
          title: {
            selector: '.seu-media-title',
            allowedContent: ''
          },
          description: {   
            selector: '.seu-media-description',
            allowedContent: 'p,br,em,strong,u'
          }
        },
        // Template généré
        template: quoteTemplate,
        upcast: function(element) {
          return element.name == 'div' && element.hasClass('seu-wi-embed')
        }
      });

      instance._videoTPL = new CKEDITOR.template(TPL_VIDEO);

      editor.addCommand('videoselector', {
        canUndo: false,
        exec(editor, callback) {
          const onSelectedVideoChangeFn = AUI().bind(
              '_onSelectedVideoChange',
              instance,
              editor,
              callback
          );

          instance._openSelectionModal(
              editor,
              editor.config.videobrowserVideoBrowseUrl,
              onSelectedVideoChangeFn
          );
        },
      });

      if (editor.ui.addButton) {
        editor.ui.addButton("VideoSelector", {
          command: "videoselector",
          icon: instance.path + "assets/videoselector.png",
          label: "Insérer une vidéo"
        });
      }

      CKEDITOR.on("dialogDefinition", function(event) {
        var dialogName = event.data.name;

        var dialogDefinition = event.data.definition;

        if (dialogName === "video") {
          instance._bindBrowseButton(
            editor,
            dialogDefinition,
            "info",
            "videoselector",
            "url"
          );
        }
      });

      editor.once("destroy", function() {
        if (instance._itemSelectorDialog) {
          instance._itemSelectorDialog.destroy();
        }
      });
    },

    _bindBrowseButton: function(
      editor,
      dialogDefinition,
      tabName,
      commandName,
      targetField
    ) {
      var tab = dialogDefinition.getContents(tabName);

      if (tab) {
        var browseButton = tab.get("browse");

        if (browseButton) {
          browseButton.onClick = function() {
            editor.execCommand(commandName, function(newVal) {
              dialogDefinition.dialog.setValueOf(tabName, targetField, newVal);
            });
          };
        }
      }
    },

    _openSelectionModal(editor, url, callback) {
      Liferay.Util.openSelectionModal({
        onSelect: callback,
        selectEventName: editor.name + 'selectItem',
        title: Liferay.Language.get('select-item'),
        url,
        zIndex: CKEDITOR.getNextZIndex(),
      });
    },

    _onSelectedVideoChange: function(editor, callback, selectedItem) {
      var instance = this;

      if (selectedItem && selectedItem.entityId > 0) {
        Liferay.Service(
          "/video.video/get-video",
          {
            id: selectedItem.entityId
          },
          function(response) {
            var htmlToInsert = instance._videoTPL.output({
              title: response.title.fr_FR,
              description: response.description.fr_FR,
              player: response.player .fr_FR
            });
            editor.insertHtml(htmlToInsert);
          }
        );
      }
    }

  });
})();
