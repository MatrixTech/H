namespace WindowsFormsApplication1
{
    partial class Interpret
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.fileChooseLoc = new System.Windows.Forms.Button();
            this.outputLoc = new System.Windows.Forms.TextBox();
            this.inputLoc = new System.Windows.Forms.TextBox();
            this.fileChooseOutLoc = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.fileAction = new System.Windows.Forms.Button();
            this.getFileLoc = new System.Windows.Forms.OpenFileDialog();
            this.getOutLoc = new System.Windows.Forms.SaveFileDialog();
            this.SuspendLayout();
            // 
            // fileChooseLoc
            // 
            this.fileChooseLoc.Location = new System.Drawing.Point(386, 4);
            this.fileChooseLoc.Name = "fileChooseLoc";
            this.fileChooseLoc.Size = new System.Drawing.Size(98, 23);
            this.fileChooseLoc.TabIndex = 0;
            this.fileChooseLoc.Text = "Choose FIle...";
            this.fileChooseLoc.UseVisualStyleBackColor = true;
            this.fileChooseLoc.Click += new System.EventHandler(this.fileChooseLoc_Click);
            // 
            // outputLoc
            // 
            this.outputLoc.Enabled = false;
            this.outputLoc.Location = new System.Drawing.Point(101, 32);
            this.outputLoc.Name = "outputLoc";
            this.outputLoc.Size = new System.Drawing.Size(279, 20);
            this.outputLoc.TabIndex = 1;
            // 
            // inputLoc
            // 
            this.inputLoc.Enabled = false;
            this.inputLoc.Location = new System.Drawing.Point(85, 6);
            this.inputLoc.Name = "inputLoc";
            this.inputLoc.Size = new System.Drawing.Size(295, 20);
            this.inputLoc.TabIndex = 2;
            // 
            // fileChooseOutLoc
            // 
            this.fileChooseOutLoc.Location = new System.Drawing.Point(386, 30);
            this.fileChooseOutLoc.Name = "fileChooseOutLoc";
            this.fileChooseOutLoc.Size = new System.Drawing.Size(98, 23);
            this.fileChooseOutLoc.TabIndex = 3;
            this.fileChooseOutLoc.Text = "Choose FIle...";
            this.fileChooseOutLoc.UseVisualStyleBackColor = true;
            this.fileChooseOutLoc.Click += new System.EventHandler(this.fileChooseOutLoc_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(67, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "File Location";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 35);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(83, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Output Location";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // fileAction
            // 
            this.fileAction.Location = new System.Drawing.Point(386, 59);
            this.fileAction.Name = "fileAction";
            this.fileAction.Size = new System.Drawing.Size(98, 23);
            this.fileAction.TabIndex = 6;
            this.fileAction.Text = "Convert!";
            this.fileAction.UseVisualStyleBackColor = true;
            this.fileAction.Click += new System.EventHandler(this.fileAction_Click);
            // 
            // getFileLoc
            // 
            this.getFileLoc.FileName = "openFileDialog1";
            this.getFileLoc.Filter = "H# Files (*.hsf)|*.hsf";
            this.getFileLoc.FileOk += new System.ComponentModel.CancelEventHandler(this.getFIleLoc_FileOk);
            // 
            // getOutLoc
            // 
            this.getOutLoc.Filter = "HTML Files (*.html)|*.html";
            // 
            // Interpret
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(496, 86);
            this.Controls.Add(this.fileAction);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.fileChooseOutLoc);
            this.Controls.Add(this.inputLoc);
            this.Controls.Add(this.outputLoc);
            this.Controls.Add(this.fileChooseLoc);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "Interpret";
            this.Text = "H# File to HTML";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button fileChooseLoc;
        private System.Windows.Forms.TextBox outputLoc;
        private System.Windows.Forms.TextBox inputLoc;
        private System.Windows.Forms.Button fileChooseOutLoc;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button fileAction;
        private System.Windows.Forms.OpenFileDialog getFileLoc;
        private System.Windows.Forms.SaveFileDialog getOutLoc;
    }
}

