package funciones;

import java.util.Objects;

public class FuncionesPunto {

		private double y ;
		private double x;
		
		public FuncionesPunto(double y, double x) {
			this.y = y;
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public double getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FuncionesPunto other = (FuncionesPunto) obj;
			return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
					&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
		}
		@Override
		public String toString() {
			return "FunionesPunto (" + x + "," + y + ")";
		}

}
