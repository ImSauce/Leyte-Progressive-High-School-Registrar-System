package SystemOtherComps;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import SystemFunctions.Constants;
import SystemFunctions.CustomRoundBorder;
import java.awt.Color;
import java.awt.Shape;
import javax.swing.Icon;

public class PH_Panel extends JPanel {
    
    public boolean isAA_DrawLeftBorder() {
        return AA_DrawLeftBorder;
    }
    
    public void setAA_DrawLeftBorder(boolean AA_DrawLeftBorder) {
        this.AA_DrawLeftBorder = AA_DrawLeftBorder;
    }
    
    public boolean isAA_DrawRightBorder() {
        return AA_DrawRightBorder;
    }
    
    public void setAA_DrawRightBorder(boolean AA_DrawRightBorder) {
        this.AA_DrawRightBorder = AA_DrawRightBorder;
    }
    
    public boolean isAA_DrawTopBorder() {
        return AA_DrawTopBorder;
    }
    
    public void setAA_DrawTopBorder(boolean AA_DrawTopBorder) {
        this.AA_DrawTopBorder = AA_DrawTopBorder;
    }
    
    public boolean isAA_DrawBottomBorder() {
        return AA_DrawBottomBorder;
    }
    
    public void setAA_DrawBottomBorder(boolean AA_DrawBottomBorder) {
        this.AA_DrawBottomBorder = AA_DrawBottomBorder;
    }
    
    public int getAA_ArcSize() {
        return AA_ArcSize;
    }
    
    public void setAA_ArcSize(int AA_ArcSize) {
        this.AA_ArcSize = AA_ArcSize;
    }
    
    public int getAA_BorderSize() {
        return AA_BorderSize;
    }
    
    public void setAA_BorderSize(int AA_BorderSize) {
        this.AA_BorderSize = AA_BorderSize;
    }
    
    public int getAA_ImageIndent() {
        return AA_ImageIndent;
    }
    
    public void setAA_ImageIndent(int AA_ImageIndent) {
        this.AA_ImageIndent = AA_ImageIndent;
    }
    
    public int getAAA_ImageBoundArcSize() {
        return AAA_ImageBoundArcSize;
    }
    
    public void setAAA_ImageBoundArcSize(int AAA_ImageBoundArcSize) {
        this.AAA_ImageBoundArcSize = AAA_ImageBoundArcSize;
    }
    
    public int getAAA_roundTopLeft() {
        return AAA_roundTopLeft;
    }
    
    public void setAAA_roundTopLeft(int AAA_roundTopLeft) {
        this.AAA_roundTopLeft = AAA_roundTopLeft;
    }
    
    public int getAAA_roundTopRight() {
        return AAA_roundTopRight;
    }
    
    public void setAAA_roundTopRight(int AAA_roundTopRight) {
        this.AAA_roundTopRight = AAA_roundTopRight;
    }
    
    public int getAAA_roundBottomLeft() {
        return AAA_roundBottomLeft;
    }
    
    public void setAAA_roundBottomLeft(int AAA_roundBottomLeft) {
        this.AAA_roundBottomLeft = AAA_roundBottomLeft;
    }
    
    public int getAAA_roundBottomRight() {
        return AAA_roundBottomRight;
    }
    
    public void setAAA_roundBottomRight(int AAA_roundBottomRight) {
        this.AAA_roundBottomRight = AAA_roundBottomRight;
    }
    
    public Color getAA_BorderColor() {
        return AA_BorderColor;
    }
    
    public void setAA_BorderColor(Color AA_BorderColor) {
        this.AA_BorderColor = AA_BorderColor;
    }
    
    public Color getAA_PanelColor() {
        return AA_PanelColor;
    }
    
    public void setAA_PanelColor(Color AA_PanelColor) {
        this.AA_PanelColor = AA_PanelColor;
    }
    
    public boolean isAA_ResizeableImageBound() {
        return AA_ResizeableImageBound;
    }
    
    public void setAA_ResizeableImageBound(boolean AA_ResizeableImageBound) {
        this.AA_ResizeableImageBound = AA_ResizeableImageBound;
    }
    
    public boolean isAA_DrawBorder() {
        return AA_DrawBorder;
    }
    
    public void setAA_DrawBorder(boolean AA_DrawBorder) {
        this.AA_DrawBorder = AA_DrawBorder;
        repaint();
    }
    
    public boolean isAA_DrawImage() {
        return AA_DrawImage;
    }
    
    public void setAA_DrawImage(boolean AA_DrawImage) {
        this.AA_DrawImage = AA_DrawImage;
    }
    
    public boolean isAAA_FitToSize() {
        return AAA_FitToSize;
    }
    
    public void setAAA_FitToSize(boolean AAA_FitToSize) {
        this.AAA_FitToSize = AAA_FitToSize;
    }
    
    public boolean isAAA_AutoFitToSize() {
        return AAA_AutoFitToSize;
    }
    
    public void setAAA_AutoFitToSize(boolean AAA_AutoFitToSize) {
        this.AAA_AutoFitToSize = AAA_AutoFitToSize;
    }
    
    public boolean isAAA_AutoSize() {
        return AAA_AutoSize;
    }
    
    public void setAAA_AutoSize(boolean AAA_AutoSize) {
        this.AAA_AutoSize = AAA_AutoSize;
    }
    
    public boolean isAAA_AutoFillSize() {
        return AAA_AutoFillSize;
    }
    
    public void setAAA_AutoFillSize(boolean AAA_AutoFillSize) {
        this.AAA_AutoFillSize = AAA_AutoFillSize;
    }
    
    public boolean isAA_OpaqueBackground() {
        return AA_OpaqueBackground;
    }
    
    public void setAA_OpaqueBackground(boolean AA_OpaqueBackground) {
        this.AA_OpaqueBackground = AA_OpaqueBackground;
    }
    
    public Icon getAA_CompImage() {
        return AA_CompImage;
    }
    
    public void setAA_CompImage(Icon AA_CompImage) {
        this.AA_CompImage = AA_CompImage;
    }
    
    public PH_Panel() {
        setOpaque(false);
        setBackground(AA_PanelColor);
        setPreferredSize(Constants.UI_Default_Size);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        //Initialization for the Custom round Border
        Shape createRoundTopLeft = CustomRoundBorder.createRoundTopLeft(this, AAA_roundTopLeft);
        Shape createRoundTopRight = CustomRoundBorder.createRoundTopRight(this, AAA_roundTopRight);
        Shape createRoundBottomLeft = CustomRoundBorder.createRoundBottomLeft(this, AAA_roundBottomLeft);
        Shape createRoundBottomRight = CustomRoundBorder.createRoundBottomRight(this, AAA_roundBottomRight);
        Shape createRoundTopLeftB = CustomRoundBorder.createRoundTopLeftB(this, AAA_roundTopLeft, AA_BorderSize);
        Shape createRoundTopRightB = CustomRoundBorder.createRoundTopRightB(this, AAA_roundTopRight, AA_BorderSize);
        Shape createRoundBottomLeftB = CustomRoundBorder.createRoundBottomLeftB(this, AAA_roundBottomLeft, AA_BorderSize);
        Shape createRoundBottomRightB = CustomRoundBorder.createRoundBottomRightB(this, AAA_roundBottomRight, AA_BorderSize);
        g2.setColor(AA_BorderColor);
        //Creation of the Roundborder
        Constants.DrawCustomBorder(g2, AA_OpaqueBackground,AA_DrawBorder, AA_BorderColor, getBackground(), AAA_roundTopRight, AAA_roundBottomLeft, AAA_roundBottomRight,
                createRoundTopLeft, createRoundTopRight, createRoundBottomLeft, createRoundBottomRight,
                createRoundTopLeftB, createRoundTopRightB, createRoundBottomLeftB, createRoundBottomRightB);
        //Responsible for creating the image, and its own bounds
        if (AA_DrawBorder == true) {
            Constants.resizableImageBound(AA_ResizeableImageBound, g2, AAA_ImageBoundArcSize, AA_ArcSize, width, height, AA_BorderSize, AA_ImageIndent);
            Constants.paintImageWithBorder(AA_ImageIndent, AA_BorderSize, this, g2, AA_DrawImage, AA_CompImage, AAA_FitToSize, AAA_AutoFitToSize, AAA_AutoSize, AAA_AutoFillSize);
        } else {
            Constants.CreateCustomBorders(this, g2, AA_BorderColor, AA_BorderSize, AA_DrawLeftBorder, AA_DrawRightBorder, AA_DrawTopBorder, AA_DrawBottomBorder);
            Constants.resizableImageBound(AA_ResizeableImageBound, g2, AAA_ImageBoundArcSize, AA_ArcSize, width, height, AA_BorderSize, AA_ImageIndent);
            Constants.paintImage(AA_ImageIndent, this, g2, AA_DrawImage, AA_CompImage, AAA_FitToSize, AAA_AutoFitToSize, AAA_AutoSize, AAA_AutoFillSize);
        } super.paintComponent(g);
    }
    
    private int AA_ArcSize = Constants.UI_Default_ArcSize;
    private int AA_BorderSize = Constants.UI_Default_BorderSize;
    private int AA_ImageIndent = Constants.UI_Default_Indent;
    private int AAA_ImageBoundArcSize = Constants.UI_Default_ImageBoundArcSize;
    private int AAA_roundTopLeft = Constants.UI_Default_RoundTopLeft;
    private int AAA_roundTopRight = Constants.UI_Default_RoundTopRight;
    private int AAA_roundBottomLeft = Constants.UI_Default_RoundBottomLeft;
    private int AAA_roundBottomRight = Constants.UI_Default_RoundBottomRight;
    private Color AA_BorderColor = Constants.UI_Default_BorderColor;
    private Color AA_PanelColor = Constants.UI_Default_CompColor;
    
    private boolean AA_ResizeableImageBound = Constants.UI_Default_ResizeableImageBound;
    private boolean AA_DrawBorder = Constants.UI_Default_DrawBorder;
    private boolean AA_DrawImage = Constants.UI_Default_DrawImage;
    private boolean AAA_FitToSize = Constants.UI_Default_FitToSize;
    private boolean AAA_AutoFitToSize = Constants.UI_Default_AutoFitToSize;
    private boolean AAA_AutoSize = Constants.UI_Default_AutoSize;
    private boolean AAA_AutoFillSize = Constants.UI_Default_AutoFillSize;
    private boolean AA_DrawLeftBorder = Constants.UI_Default_DrawLeftBorder;
    private boolean AA_DrawRightBorder = Constants.UI_Default_DrawRightBorder;
    private boolean AA_DrawTopBorder = Constants.UI_Default_DrawTopBorder;
    private boolean AA_DrawBottomBorder = Constants.UI_Default_DrawBottomBorder;
    private boolean AA_OpaqueBackground = Constants.UI_Default_OpaqueBackground;
    
    private Icon AA_CompImage;
}
