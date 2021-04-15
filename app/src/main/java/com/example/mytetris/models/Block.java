package com.example.mytetris.models;
import com.example.mytetris.constants.FieldConstants;

import android.graphics.Color;
import android.graphics.Point;
import androidx.annotation.NonNull;


public class Block {
    private int shapeIndex;
    private int frameNumber;
    private BlockColor color;
    private Point position;

    public enum BlockColor {
        PINK(Color.rgb(255, 105, 180), (byte) 2),
        GREEN(Color.rgb(0, 128, 0), (byte) 3),
        ORANGE(Color.rgb(255, 140, 0), (byte) 4),
        YELLOW(Color.rgb(255, 255, 0), (byte) 5),
        CYAN(Color.rgb(0, 255, 255), (byte) 6);

        BlockColor(int rgbValue, byte value) {
            this.rgbValue = rgbValue;
            this.byteValue = value;
        }

        private final int rgbValue;
        private final byte byteValue;
    }

    public static int getColor(byte value) {
        for (BlockColor colour : BlockColor.values()) {
            if (value == colour.byteValue) {
                return colour.rgbValue;
            }
        }
        return -1;
    }
    public final void setState(int frame, Point position) {
        this.frameNumber = frame; this.position = position;
    }
    @NonNull
    public final byte[][] getShape(int frameNumber) {
        return Shape.values()[shapeIndex].getFrame(
                frameNumber).as2dByteArray();
    }

    public Point getPosition() {
        this.position = new Point(FieldConstants.COLUMN_COUNT.getValue()/2, 0);
        return this.position;
    }

    public final int getFrameCount() {
        return Shape.values()[shapeIndex].getFrameCount();
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public int getColor() {
        return color.rgbValue;
    }

    public byte getStaticValue() {
        return color.byteValue;
    }
}
