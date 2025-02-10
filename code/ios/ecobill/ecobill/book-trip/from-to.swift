import SwiftUI

struct from_to: View {
    var body: some View {
        VStack {
            HStack {
                Label("From", systemImage: "arrow.triangle.2.circlepath")
                Spacer()
                TextField("From", text: .constant(""))
            }
            HStack {
                Label("To", systemImage: "arrow.triangle.2.circlepath")
                Spacer()
                TextField("To", text: .constant(""))
            }
        }
    }
}

#Preview {
    from_to()
}
