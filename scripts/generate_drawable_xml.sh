#!/bin/sh

DRAWABLE_ROOT=app/src/main/res/drawable
DRAWABLE_XML=app/src/main/res/xml/drawable.xml

echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>"	>  $DRAWABLE_XML
echo "<resources>"					>> $DRAWABLE_XML
echo "    <version>1</version>"				>> $DRAWABLE_XML

for file in $DRAWABLE_ROOT/icon_*.png; do
	DRAWABLE_NAME=$(basename $file .png)
	echo "    <item drawable=\"$DRAWABLE_NAME\" />"	>> $DRAWABLE_XML
done

echo "</resources>"					>> $DRAWABLE_XML
