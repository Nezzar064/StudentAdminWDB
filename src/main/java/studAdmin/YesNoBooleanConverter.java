package studAdmin;

import javax.persistence.AttributeConverter;

public class YesNoBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
       return dbData.equals("Y");
    }
}
