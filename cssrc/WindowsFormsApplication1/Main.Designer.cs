namespace WindowsFormsApplication1
{
    partial class Main
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
            this.MenuInterpret = new System.Windows.Forms.Button();
            this.menuNew = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // MenuInterpret
            // 
            this.MenuInterpret.Location = new System.Drawing.Point(12, 12);
            this.MenuInterpret.Name = "MenuInterpret";
            this.MenuInterpret.Size = new System.Drawing.Size(105, 23);
            this.MenuInterpret.TabIndex = 0;
            this.MenuInterpret.Text = "Interpret File...";
            this.MenuInterpret.UseVisualStyleBackColor = true;
            this.MenuInterpret.Click += new System.EventHandler(this.button1_Click);
            // 
            // menuNew
            // 
            this.menuNew.Location = new System.Drawing.Point(12, 41);
            this.menuNew.Name = "menuNew";
            this.menuNew.Size = new System.Drawing.Size(105, 23);
            this.menuNew.TabIndex = 1;
            this.menuNew.Text = "New File...";
            this.menuNew.UseVisualStyleBackColor = true;
            this.menuNew.Click += new System.EventHandler(this.menuNew_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe Print", 72F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(141, 70);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(224, 168);
            this.label1.TabIndex = 2;
            this.label1.Text = "H#";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(12, 70);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(105, 23);
            this.button1.TabIndex = 3;
            this.button1.Text = "Open FIle...";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // Main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.WhiteSmoke;
            this.ClientSize = new System.Drawing.Size(377, 247);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuNew);
            this.Controls.Add(this.MenuInterpret);
            this.Name = "Main";
            this.Text = "Main";
            this.Load += new System.EventHandler(this.Main_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button MenuInterpret;
        private System.Windows.Forms.Button menuNew;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
    }
}