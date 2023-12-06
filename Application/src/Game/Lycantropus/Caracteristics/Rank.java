package Game.Lycantropus.Caracteristics;

public enum Rank {
    ALPHA, BETA, GAMMA, DELTA, EPSILON, ZETA, ETA, THETA, IOTA, KAPPA, LAMBDA,
    MU, NU, XI, OMICRON, PI, RHO, SIGMA, TAU, UPSILON, PHI, CHI, PSI, OMEGA;
    public Rank downgrade()
    {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
    public Rank upgrade()
    {
        if (ordinal() < values().length-1) {
            return values()[ordinal()-1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
