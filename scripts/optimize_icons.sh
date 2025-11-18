#!/bin/sh
ICON_ROOT=icons
DRAWABLE_ROOT=app/src/main/res/drawable

for ICON in $ICON_ROOT/*; do
    if [ ! -f $DRAWABLE_ROOT/$(basename $ICON) ]; then
        mogrify -resize "192x192" -path "$DRAWABLE_ROOT" "$ICON"
    fi
done

for DRAWABLE in $DRAWABLE_ROOT/icon_*; do
    if [ ! -f $ICON_ROOT/$(basename $DRAWABLE) ]; then
        rm --verbose $DRAWABLE
    fi
done
